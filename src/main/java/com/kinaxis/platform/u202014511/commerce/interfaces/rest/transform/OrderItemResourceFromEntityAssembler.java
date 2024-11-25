package com.kinaxis.platform.u202014511.commerce.interfaces.rest.transform;

import com.kinaxis.platform.u202014511.commerce.domain.model.aggregates.OrderItem;
import com.kinaxis.platform.u202014511.commerce.interfaces.rest.resources.OrderItemResource;

/**
 * Assembler class to convert OrderItem entity to OrderItemResource
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public class OrderItemResourceFromEntityAssembler {

    /**
     * Converts OrderItem entity to OrderItemResource
     * @param entity the {@link OrderItem} entity to convert
     * @return the {@link OrderItemResource} resource converted from the entity
     */
    public static OrderItemResource toResourceFromEntity(OrderItem entity) {
        return new OrderItemResource(
                entity.getId(),
                entity.getOrderId(),
                entity.getKinaxisSku(),
                entity.getRequestedQuantity(),
                entity.getStatus(),
                entity.getOrderedAt()
        );
    }
}
