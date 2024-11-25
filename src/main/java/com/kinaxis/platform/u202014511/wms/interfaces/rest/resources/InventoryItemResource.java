package com.kinaxis.platform.u202014511.wms.interfaces.rest.resources;

/**
 * Inventory item resource
 * @param id the id of the inventory item
 * @param kinaxisSku the sku of the inventory item
 * @param status the status of the inventory item
 * @param minimumQuantity the minimum quantity of the inventory item
 * @param availableQuantity the available quantity of the inventory item
 * @param reservedQuantity the reserved quantity of the inventory item
 * @param pendingSupplyQuantity the pending supply quantity of the inventory item
 */
public record InventoryItemResource(
        Long id,
        String kinaxisSku,
        String status,
        Double minimumQuantity,
        Double availableQuantity,
        Double reservedQuantity,
        Double pendingSupplyQuantity
) {
}
