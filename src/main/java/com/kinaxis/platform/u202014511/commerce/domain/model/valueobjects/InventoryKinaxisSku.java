package com.kinaxis.platform.u202014511.commerce.domain.model.valueobjects;

import java.util.UUID;

/**
 * Value object for Kinaxis SKU of an inventory item
 * @param sku the Kinaxis SKU value as a string
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
public record InventoryKinaxisSku(String sku) {
    public InventoryKinaxisSku(String sku) {
        this.sku = UUID.fromString(sku).toString();
    }
}
