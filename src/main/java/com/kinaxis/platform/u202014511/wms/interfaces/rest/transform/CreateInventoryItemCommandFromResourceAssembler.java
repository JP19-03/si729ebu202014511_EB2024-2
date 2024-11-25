package com.kinaxis.platform.u202014511.wms.interfaces.rest.transform;

import com.kinaxis.platform.u202014511.wms.domain.model.commands.CreateInventoryItemCommand;
import com.kinaxis.platform.u202014511.wms.interfaces.rest.resources.CreateInventoryItemResource;

/**
 * Assembler class to convert CreateInventoryItemResource to CreateInventoryItemCommand
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public class CreateInventoryItemCommandFromResourceAssembler {

    /**
     * Converts a CreateInventoryItemResource to a CreateInventoryItemCommand
     * @param resource the {@link CreateInventoryItemResource} to convert
     * @return the {@link CreateInventoryItemCommand} converted
     */
    public static CreateInventoryItemCommand toCommandFromResource(CreateInventoryItemResource resource) {
        return new CreateInventoryItemCommand(
                resource.kinaxisSku(),
                resource.minimumQuantity(),
                resource.availableQuantity()
        );
    }
}
