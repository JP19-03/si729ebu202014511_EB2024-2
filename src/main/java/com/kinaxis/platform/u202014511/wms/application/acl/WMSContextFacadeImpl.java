package com.kinaxis.platform.u202014511.wms.application.acl;

import com.kinaxis.platform.u202014511.wms.domain.exceptions.NotFoundInventoryItemException;
import com.kinaxis.platform.u202014511.wms.domain.model.valueobjects.KinaxisSku;
import com.kinaxis.platform.u202014511.wms.infrastructure.persistence.jpa.repositories.InventoryItemRepository;
import com.kinaxis.platform.u202014511.wms.interfaces.acl.WMSContextFacade;
import org.springframework.stereotype.Service;

@Service
public class WMSContextFacadeImpl implements WMSContextFacade {
    private final InventoryItemRepository inventoryItemRepository;

    public WMSContextFacadeImpl(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    @Override
    public void existsInventoryItem(String sku) {
        if (!inventoryItemRepository.existsByKinaxisSku(new KinaxisSku(sku))) {
            throw new NotFoundInventoryItemException(sku);
        }
    }

    @Override
    public Double getInventoryItemAvailableQuantity(String sku) {
        var inventoryItem = inventoryItemRepository.findByKinaxisSku(new KinaxisSku(sku))
                .orElseThrow(() -> new NotFoundInventoryItemException(sku));
        return inventoryItem.getAvailableQuantity();
    }

    @Override
    public Double getInventoryItemReservedQuantity(String sku) {
        var inventoryItem = inventoryItemRepository.findByKinaxisSku(new KinaxisSku(sku))
                .orElseThrow(() -> new NotFoundInventoryItemException(sku));
        return inventoryItem.getReservedQuantity();
    }

    @Override
    public void setInventoryItemAvailableQuantity(String sku, Double quantity) {
        var inventoryItem = inventoryItemRepository.findByKinaxisSku(new KinaxisSku(sku))
                .orElseThrow(() -> new NotFoundInventoryItemException(sku));
        inventoryItem.setAvailableQuantity(quantity);
        if (inventoryItem.getAvailableQuantity() < inventoryItem.getMinimumQuantity()) {
            inventoryItem.minimumQuantityThresholdReached();
        }
        inventoryItemRepository.save(inventoryItem);
    }

    @Override
    public void setInventoryItemReservedQuantity(String sku, Double quantity) {
        var inventoryItem = inventoryItemRepository.findByKinaxisSku(new KinaxisSku(sku))
                .orElseThrow(() -> new NotFoundInventoryItemException(sku));
        inventoryItem.setReservedQuantity(quantity);
        inventoryItemRepository.save(inventoryItem);
    }

    @Override
    public void setInventoryItemPendingSupplyQuantity(String sku, Double quantity) {
        var inventoryItem = inventoryItemRepository.findByKinaxisSku(new KinaxisSku(sku))
                .orElseThrow(() -> new NotFoundInventoryItemException(sku));
        inventoryItem.setPendingSupplyQuantity(quantity);
        inventoryItemRepository.save(inventoryItem);
    }
}
