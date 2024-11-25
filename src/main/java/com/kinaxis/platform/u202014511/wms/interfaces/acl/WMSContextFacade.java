package com.kinaxis.platform.u202014511.wms.interfaces.acl;

public interface WMSContextFacade {
    void existsInventoryItem(String sku);
    Double getInventoryItemAvailableQuantity(String sku);
    Double getInventoryItemReservedQuantity(String sku);
    void setInventoryItemAvailableQuantity(String sku, Double quantity);
    void setInventoryItemReservedQuantity(String sku, Double quantity);
    void setInventoryItemPendingSupplyQuantity(String sku, Double quantity);
}
