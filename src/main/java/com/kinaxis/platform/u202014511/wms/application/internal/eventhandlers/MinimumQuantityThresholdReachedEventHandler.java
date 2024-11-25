package com.kinaxis.platform.u202014511.wms.application.internal.eventhandlers;

import com.kinaxis.platform.u202014511.wms.domain.model.events.MinimumQuantityThresholdReachedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Event handler for the MinimumQuantityThresholdReachedEvent.
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
@Service
public class MinimumQuantityThresholdReachedEventHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinimumQuantityThresholdReachedEventHandler.class);

    /**
     * Handles the MinimumQuantityThresholdReachedEvent.
     * @param event the event to handle
     */
    @EventListener(MinimumQuantityThresholdReachedEventHandler.class)
    public void on(MinimumQuantityThresholdReachedEvent event) {
        LOGGER.info("SCM: A supply order is needed for the product with SKU {} with at least {} units", event.getKinaxisSku(), event.getRequestedSupplyQuantity());
    }
}
