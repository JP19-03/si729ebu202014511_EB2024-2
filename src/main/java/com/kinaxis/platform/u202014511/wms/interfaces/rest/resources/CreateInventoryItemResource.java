package com.kinaxis.platform.u202014511.wms.interfaces.rest.resources;

/**
 * Resource for creating an inventory item
 * @param kinaxisSku SKU of the item
 * @param minimumQuantity Minimum quantity of the item
 * @param availableQuantity Available quantity of the item
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public record CreateInventoryItemResource(
        String kinaxisSku,
        Double minimumQuantity,
        Double availableQuantity
) {
}
