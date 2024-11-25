package com.kinaxis.platform.u202014511.wms.domain.exceptions;

/**
 * Exception thrown when the available quantity is less than twice the minimum quantity
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public class InvalidInventoryQuantityException extends RuntimeException{
    public InvalidInventoryQuantityException(Double minimumQuantity, Double availableQuantity) {
        super("The available quantity %s must be at least twice the minimum quantity %s".formatted(availableQuantity, minimumQuantity));
    }
}
