package com.kinaxis.platform.u202014511.commerce.domain.services;

import com.kinaxis.platform.u202014511.commerce.domain.model.aggregates.OrderItem;
import com.kinaxis.platform.u202014511.commerce.domain.model.commands.CreateOrderItemCommand;

import java.util.Optional;

/**
 * This interface represents the service that handles the commands related to the OrderItem entity.
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public interface OrderItemCommandService {

    /**
     * Handles the command to create an OrderItem.
     * @param command The command to create an OrderItem containing the necessary data.
     * @return An optional containing the created OrderItem if the operation was successful, an empty optional otherwise.
     */
    Optional<OrderItem> handle(CreateOrderItemCommand command);
}
