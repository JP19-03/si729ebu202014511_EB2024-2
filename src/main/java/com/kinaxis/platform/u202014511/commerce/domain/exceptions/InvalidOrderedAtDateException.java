package com.kinaxis.platform.u202014511.commerce.domain.exceptions;

import java.util.Date;

/**
 * Exception thrown when the ordered at date is in the past
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public class InvalidOrderedAtDateException extends RuntimeException{
    public InvalidOrderedAtDateException(Date orderedAt) {
        super("Ordered at date %s cannot be in the past".formatted(orderedAt));
    }
}
