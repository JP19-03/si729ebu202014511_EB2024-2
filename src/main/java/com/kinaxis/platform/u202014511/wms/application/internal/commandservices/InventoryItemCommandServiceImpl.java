package com.kinaxis.platform.u202014511.wms.application.internal.commandservices;

import com.kinaxis.platform.u202014511.wms.domain.exceptions.DuplicateInventoryItemException;
import com.kinaxis.platform.u202014511.wms.domain.exceptions.InvalidInventoryQuantityException;
import com.kinaxis.platform.u202014511.wms.domain.model.aggregates.InventoryItem;
import com.kinaxis.platform.u202014511.wms.domain.model.commands.CreateInventoryItemCommand;
import com.kinaxis.platform.u202014511.wms.domain.model.valueobjects.KinaxisSku;
import com.kinaxis.platform.u202014511.wms.domain.services.InventoryItemCommandService;
import com.kinaxis.platform.u202014511.wms.infrastructure.persistence.jpa.repositories.InventoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the {@link InventoryItemCommandService} interface.
 * @summary
 * This class is responsible for handling the commands related to the InventoryItem aggregate.
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
@Service
public class InventoryItemCommandServiceImpl implements InventoryItemCommandService {

    private final InventoryItemRepository inventoryItemRepository;

    public InventoryItemCommandServiceImpl(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    /** inheritedDoc */
    @Override
    public Optional<InventoryItem> handle(CreateInventoryItemCommand command) {
        if (inventoryItemRepository.existsByKinaxisSku(new KinaxisSku(command.kinaxisSku()))) {
            throw new DuplicateInventoryItemException(command.kinaxisSku());
        }

        if (command.availableQuantity() < 2 * command.minimumQuantity()) {
            throw new InvalidInventoryQuantityException(command.minimumQuantity(), command.availableQuantity());
        }

        var inventoryItem = new InventoryItem(command);
        inventoryItemRepository.save(inventoryItem);
        return Optional.of(inventoryItem);
    }
}
