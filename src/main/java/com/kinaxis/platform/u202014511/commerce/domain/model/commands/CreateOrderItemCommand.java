package com.kinaxis.platform.u202014511.commerce.domain.model.commands;

import java.util.Date;

/**
 * Command to create an order item
 * @param orderId The order id
 * @param kinaxisSKU The SKU of the inventory item related to this order item
 * @param requestedQuantity The quantity requested
 * @param orderedAt The date the order was placed
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public record CreateOrderItemCommand(
        Long orderId,
        String kinaxisSku,
        Double requestedQuantity,
        Date orderedAt
) {
}
