package com.kinaxis.platform.u202014511.wms.interfaces.rest;

import com.kinaxis.platform.u202014511.wms.domain.services.InventoryItemCommandService;
import com.kinaxis.platform.u202014511.wms.interfaces.rest.resources.CreateInventoryItemResource;
import com.kinaxis.platform.u202014511.wms.interfaces.rest.resources.InventoryItemResource;
import com.kinaxis.platform.u202014511.wms.interfaces.rest.transform.CreateInventoryItemCommandFromResourceAssembler;
import com.kinaxis.platform.u202014511.wms.interfaces.rest.transform.InventoryItemResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing inventory items
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/v1/inventory-items", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Inventory Items", description = "Endpoints for managing inventory items")
public class InventoryItemsController {

    private final InventoryItemCommandService inventoryItemCommandService;

    public InventoryItemsController(InventoryItemCommandService inventoryItemCommandService) {
        this.inventoryItemCommandService = inventoryItemCommandService;
    }

    /**
     * Create an inventory item
     * @param resource the {@link CreateInventoryItemResource} with the data to create the inventory item
     * @return A {@link ResponseEntity} with the created inventory item, or a bad request if the data is invalid
     */
    @PostMapping
    @Operation(summary = "Create an inventory item", description = "Create a new inventory item with the given data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Inventory item created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    public ResponseEntity<InventoryItemResource> createInventoryItem(@RequestBody CreateInventoryItemResource resource) {
        var command = CreateInventoryItemCommandFromResourceAssembler.toCommandFromResource(resource);
        var inventoryItem = inventoryItemCommandService.handle(command);
        if (inventoryItem.isEmpty()) return ResponseEntity.badRequest().build();
        var createdInventoryItem = inventoryItem.get();
        var inventoryItemResource = InventoryItemResourceFromEntityAssembler.toResourceFromEntity(createdInventoryItem);
        return new ResponseEntity<>(inventoryItemResource, HttpStatus.CREATED);
    }
}
