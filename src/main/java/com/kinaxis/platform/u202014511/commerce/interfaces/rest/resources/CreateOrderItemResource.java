package com.kinaxis.platform.u202014511.commerce.interfaces.rest.resources;

import java.util.Date;

/**
 * Resource for creating an order item.
 * @param kinaxisSku the kinaxis sku
 * @param requestedQuantity the requested quantity
 * @param orderedAt the ordered at date
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public record CreateOrderItemResource(
        String kinaxisSku,
        Double requestedQuantity,
        Date orderedAt
) {
}
