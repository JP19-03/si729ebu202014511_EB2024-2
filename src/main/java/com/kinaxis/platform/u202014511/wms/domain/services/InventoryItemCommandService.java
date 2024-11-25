package com.kinaxis.platform.u202014511.wms.domain.services;

import com.kinaxis.platform.u202014511.wms.domain.model.aggregates.InventoryItem;
import com.kinaxis.platform.u202014511.wms.domain.model.commands.CreateInventoryItemCommand;

import java.util.Optional;

/**
 * This interface represents the service that handles the commands related to the {@link InventoryItem} aggregate.
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public interface InventoryItemCommandService {

    /**
     * Handles the {@link CreateInventoryItemCommand} command.
     * @param command the command to handle.
     * @return an {@link Optional} of the created {@link InventoryItem} aggregate.
     */
    Optional<InventoryItem> handle(CreateInventoryItemCommand command);
}
