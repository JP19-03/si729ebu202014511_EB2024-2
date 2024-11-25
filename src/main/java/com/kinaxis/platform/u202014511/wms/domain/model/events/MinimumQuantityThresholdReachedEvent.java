package com.kinaxis.platform.u202014511.wms.domain.model.events;

import com.kinaxis.platform.u202014511.wms.domain.model.valueobjects.KinaxisSku;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Event that is triggered when the minimum quantity threshold is reached.
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
@Getter
public class MinimumQuantityThresholdReachedEvent extends ApplicationEvent {
    private final KinaxisSku kinaxisSku;
    private final Double requestedSupplyQuantity;

    /**
     * Creates a new MinimumQuantityThresholdReachedEvent
     *
     * @param source the object on which the event initially occurred (never {@code null})
     * @param kinaxisSku the SKU that reached the minimum quantity threshold
     * @param requestedSupplyQuantity the requested supply quantity
     */
    public MinimumQuantityThresholdReachedEvent(Object source, KinaxisSku kinaxisSku, Double requestedSupplyQuantity) {
        super(source);
        this.kinaxisSku = kinaxisSku;
        this.requestedSupplyQuantity = requestedSupplyQuantity;
    }
}
