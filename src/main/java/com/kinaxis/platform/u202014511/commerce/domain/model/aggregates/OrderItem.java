package com.kinaxis.platform.u202014511.commerce.domain.model.aggregates;

import com.kinaxis.platform.u202014511.commerce.domain.model.commands.CreateOrderItemCommand;
import com.kinaxis.platform.u202014511.commerce.domain.model.valueobjects.InventoryKinaxisSku;
import com.kinaxis.platform.u202014511.commerce.domain.model.valueobjects.OrderItemStatus;
import com.kinaxis.platform.u202014511.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * OrderItem
 * @summary
 * This class represents the OrderItem aggregate root.
 * It contains the information of an order item.
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
@Entity
public class OrderItem extends AuditableAbstractAggregateRoot<OrderItem> {

    @Getter
    @NotNull
    @Min(1)
    private Long orderId;

    @NotNull
    @Embedded
    private InventoryKinaxisSku kinaxisSku;

    @Getter
    @NotNull
    @Min(1)
    private Double requestedQuantity;

    @NotNull
    @Setter
    private OrderItemStatus status;

    @Getter
    @NotNull
    private Date orderedAt;

    protected OrderItem() {}

    /**
     * Create a new OrderItem
     * @param command the command to create the OrderItem
     * @see CreateOrderItemCommand
     */
    public OrderItem(CreateOrderItemCommand command) {
        this.orderId = command.orderId();
        this.kinaxisSku = new InventoryKinaxisSku(command.kinaxisSku());
        this.requestedQuantity = command.requestedQuantity();
        this.orderedAt = command.orderedAt();
    }

    public String getKinaxisSku() {
        return kinaxisSku.sku();
    }

    public String getStatus() {
        return status.name();
    }
}
