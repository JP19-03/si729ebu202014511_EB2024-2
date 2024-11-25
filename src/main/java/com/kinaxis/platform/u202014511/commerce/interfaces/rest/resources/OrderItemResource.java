package com.kinaxis.platform.u202014511.commerce.interfaces.rest.resources;

import java.util.Date;

/**
 * OrderItemResource
 * @param id the id of the order item
 * @param orderId the id of the order
 * @param kinaxisSku the kinaxis sku of the inventory item
 * @param requestedQuantity the requested quantity
 * @param status the status of the order item
 * @param orderedAt the date the order was placed
 */
public record OrderItemResource(
        Long id,
        Long orderId,
        String kinaxisSku,
        Double requestedQuantity,
        String status,
        Date orderedAt
) {
}
