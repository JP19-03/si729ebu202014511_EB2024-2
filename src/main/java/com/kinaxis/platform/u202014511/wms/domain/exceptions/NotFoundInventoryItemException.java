package com.kinaxis.platform.u202014511.wms.domain.exceptions;

public class NotFoundInventoryItemException extends RuntimeException {
    public NotFoundInventoryItemException(String sku) {
        super("Inventory item with SKU %s does not exist".formatted(sku));
    }
}
