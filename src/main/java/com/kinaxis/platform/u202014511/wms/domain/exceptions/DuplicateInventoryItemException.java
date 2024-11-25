package com.kinaxis.platform.u202014511.wms.domain.exceptions;

/**
 * Exception thrown when an inventory item with the same Kinaxis SKU already exists
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public class DuplicateInventoryItemException extends RuntimeException{
    public DuplicateInventoryItemException(String kinaxisSku) {
        super("Inventory item with Kinaxis SKU %s already exists".formatted(kinaxisSku));
    }
}
