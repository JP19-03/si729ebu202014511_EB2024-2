package com.kinaxis.platform.u202014511.wms.domain.model.commands;

/**
 * Command to create an inventory item
 * @param kinaxisSku SKU of the item
 * @param minimumQuantity Minimum quantity of the item
 * @param availableQuantity Available quantity of the item
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public record CreateInventoryItemCommand(
        String kinaxisSku,
        Double minimumQuantity,
        Double availableQuantity
) {
}
