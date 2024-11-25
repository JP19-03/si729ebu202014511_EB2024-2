package com.kinaxis.platform.u202014511.commerce.application.internal.commandservices;

import com.kinaxis.platform.u202014511.commerce.application.internal.outboundservices.acl.ExternalWMSService;
import com.kinaxis.platform.u202014511.commerce.domain.exceptions.DuplicateOrderItemException;
import com.kinaxis.platform.u202014511.commerce.domain.exceptions.InvalidOrderedAtDateException;
import com.kinaxis.platform.u202014511.commerce.domain.model.aggregates.OrderItem;
import com.kinaxis.platform.u202014511.commerce.domain.model.commands.CreateOrderItemCommand;
import com.kinaxis.platform.u202014511.commerce.domain.model.valueobjects.InventoryKinaxisSku;
import com.kinaxis.platform.u202014511.commerce.domain.model.valueobjects.OrderItemStatus;
import com.kinaxis.platform.u202014511.commerce.domain.services.OrderItemCommandService;
import com.kinaxis.platform.u202014511.commerce.infrastructure.persistence.jpa.repositories.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * Implementation of the {@link OrderItemCommandService} interface.
 * @summary
 * This class is responsible for handling the commands related to the {@link OrderItem} entity.
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
@Service
public class OrderItemCommandServiceImpl implements OrderItemCommandService {
    private final OrderItemRepository orderItemRepository;
    private final ExternalWMSService externalWMSService;

    public OrderItemCommandServiceImpl(OrderItemRepository orderItemRepository, ExternalWMSService externalWMSService) {
        this.orderItemRepository = orderItemRepository;
        this.externalWMSService = externalWMSService;
    }

    /** inherited doc */
    @Override
    public Optional<OrderItem> handle(CreateOrderItemCommand command) {
        externalWMSService.existInventoryItem(command.kinaxisSku());

        if (orderItemRepository.existsByOrderIdAndKinaxisSku(command.orderId(), new InventoryKinaxisSku(command.kinaxisSku()))) {
            throw new DuplicateOrderItemException(command.orderId(), command.kinaxisSku());
        }

        if (command.orderedAt().before(new Date())) {
            throw new InvalidOrderedAtDateException(command.orderedAt());
        }

        var orderItemStatus = processOrderItem(command.requestedQuantity(), command.kinaxisSku());
        var orderItem = new OrderItem(command);
        orderItem.setStatus(orderItemStatus);

        orderItemRepository.save(orderItem);

        return Optional.of(orderItem);
    }

    /**
     * Process the order item.
     * @param requestedQuantity the requested quantity
     * @param sku the SKU of the inventory item
     * @return the status of the order item
     */
    private OrderItemStatus processOrderItem(Double requestedQuantity, String sku) {
        Double availableQuantity = externalWMSService.getInventoryItemAvailableQuantity(sku);
        Double reservedQuantity = externalWMSService.getInventoryItemReservedQuantity(sku);

        if (requestedQuantity <= availableQuantity) {
            externalWMSService.setInventoryItemAvailableQuantity(sku, availableQuantity - requestedQuantity);
            externalWMSService.setInventoryItemReservedQuantity(sku, reservedQuantity + requestedQuantity);
            return OrderItemStatus.READY_FOR_DISPATCH;
        } else {
            externalWMSService.setInventoryItemAvailableQuantity(sku, 0.0);
            externalWMSService.setInventoryItemReservedQuantity(sku, reservedQuantity + availableQuantity);
            externalWMSService.setInventoryItemPendingSupplyQuantity(sku, requestedQuantity - availableQuantity);
            return OrderItemStatus.IN_PROCESS;
        }
    }
}

