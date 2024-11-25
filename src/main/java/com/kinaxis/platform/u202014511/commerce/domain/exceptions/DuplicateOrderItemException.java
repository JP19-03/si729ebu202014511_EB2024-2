package com.kinaxis.platform.u202014511.commerce.domain.exceptions;

/**
 * Exception thrown when an order already contains an item with the same sku
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public class DuplicateOrderItemException extends RuntimeException{
    public DuplicateOrderItemException(Long orderId, String sku) {
        super("Order with id %d already contains an item with sku %s".formatted(orderId, sku));
    }
}
