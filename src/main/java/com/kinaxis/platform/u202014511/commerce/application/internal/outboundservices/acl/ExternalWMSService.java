package com.kinaxis.platform.u202014511.commerce.application.internal.outboundservices.acl;

import com.kinaxis.platform.u202014511.wms.interfaces.acl.WMSContextFacade;
import org.springframework.stereotype.Service;

/**
 * This class is a facade for the WMSContextFacade class.
 * It provides a way to interact with the WMSContextFacade class.
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
@Service
public class ExternalWMSService {
    private final WMSContextFacade wmsContextFacade;

    public ExternalWMSService(WMSContextFacade wmsContextFacade) {
        this.wmsContextFacade = wmsContextFacade;
    }

    public void existInventoryItem(String sku) {
        wmsContextFacade.existsInventoryItem(sku);
    }

    public Double getInventoryItemAvailableQuantity(String sku) {
        return wmsContextFacade.getInventoryItemAvailableQuantity(sku);
    }

    public Double getInventoryItemReservedQuantity(String sku) {
        return wmsContextFacade.getInventoryItemReservedQuantity(sku);
    }

    public void setInventoryItemAvailableQuantity(String sku, Double quantity) {
        wmsContextFacade.setInventoryItemAvailableQuantity(sku, quantity);
    }

    public void setInventoryItemReservedQuantity(String sku, Double quantity) {
        wmsContextFacade.setInventoryItemReservedQuantity(sku, quantity);
    }

    public void setInventoryItemPendingSupplyQuantity(String sku, Double quantity) {
        wmsContextFacade.setInventoryItemPendingSupplyQuantity(sku, quantity);
    }
}
