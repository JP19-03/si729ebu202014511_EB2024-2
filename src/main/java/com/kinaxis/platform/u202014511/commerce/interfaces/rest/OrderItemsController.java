package com.kinaxis.platform.u202014511.commerce.interfaces.rest;

import com.kinaxis.platform.u202014511.commerce.domain.services.OrderItemCommandService;
import com.kinaxis.platform.u202014511.commerce.interfaces.rest.resources.CreateOrderItemResource;
import com.kinaxis.platform.u202014511.commerce.interfaces.rest.resources.OrderItemResource;
import com.kinaxis.platform.u202014511.commerce.interfaces.rest.transform.CreateOrderItemCommandFromResourceAssembler;
import com.kinaxis.platform.u202014511.commerce.interfaces.rest.transform.OrderItemResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing order items
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Order Items", description = "Endpoints for managing order items")
public class OrderItemsController {

    private final OrderItemCommandService orderItemCommandService;

    public OrderItemsController(OrderItemCommandService orderItemCommandService) {
        this.orderItemCommandService = orderItemCommandService;
    }

    /**
     * Create order item for a given order
     * @param orderId the order id
     * @param resource the order item resource
     * @return the created order item, or a bad request response if the request is invalid
     */
    @PostMapping("/{orderId}/items")
    @Operation(summary = "Create order item", description = "Create order item for a given order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order item created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    public ResponseEntity<OrderItemResource> createOrderItem(@PathVariable Long orderId, @RequestBody CreateOrderItemResource resource) {
        var command = CreateOrderItemCommandFromResourceAssembler.toCommandFromResource(resource, orderId);
        var orderItem = orderItemCommandService.handle(command);
        if (orderItem.isEmpty()) return ResponseEntity.badRequest().build();
        var createdOrderItem = orderItem.get();
        var orderItemResource = OrderItemResourceFromEntityAssembler.toResourceFromEntity(createdOrderItem);
        return new ResponseEntity<>(orderItemResource, HttpStatus.CREATED);
    }
}
