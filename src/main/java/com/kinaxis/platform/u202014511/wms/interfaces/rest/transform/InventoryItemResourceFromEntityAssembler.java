package com.kinaxis.platform.u202014511.wms.interfaces.rest.transform;

import com.kinaxis.platform.u202014511.wms.domain.model.aggregates.InventoryItem;
import com.kinaxis.platform.u202014511.wms.interfaces.rest.resources.InventoryItemResource;

public class InventoryItemResourceFromEntityAssembler {
    public static InventoryItemResource toResourceFromEntity(InventoryItem entity) {
        return new InventoryItemResource(
                entity.getId(),
                entity.getKinaxisSku(),
                entity.getStatus(),
                entity.getMinimumQuantity(),
                entity.getAvailableQuantity(),
                entity.getReservedQuantity(),
                entity.getPendingSupplyQuantity()
        );
    }
}
