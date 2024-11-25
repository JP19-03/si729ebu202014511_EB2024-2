package com.kinaxis.platform.u202014511.commerce.interfaces.rest.transform;

import com.kinaxis.platform.u202014511.commerce.domain.model.commands.CreateOrderItemCommand;
import com.kinaxis.platform.u202014511.commerce.interfaces.rest.resources.CreateOrderItemResource;

/**
 * Assembly class to convert a CreateOrderItemResource to a CreateOrderItemCommand.
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public class CreateOrderItemCommandFromResourceAssembler {

    /**
     * Converts a CreateOrderItemResource to a CreateOrderItemCommand.
     * @param resource The {@link CreateOrderItemResource} to convert.
     * @return The {@link CreateOrderItemCommand} created.
     */
    public static CreateOrderItemCommand toCommandFromResource(CreateOrderItemResource resource, Long id) {
        return new CreateOrderItemCommand(
                id,
                resource.kinaxisSku(),
                resource.requestedQuantity(),
                resource.orderedAt()
        );
    }
}
