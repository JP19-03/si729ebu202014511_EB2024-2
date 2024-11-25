package com.kinaxis.platform.u202014511.wms.domain.model.aggregates;

import com.kinaxis.platform.u202014511.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.kinaxis.platform.u202014511.wms.domain.model.commands.CreateInventoryItemCommand;
import com.kinaxis.platform.u202014511.wms.domain.model.events.MinimumQuantityThresholdReachedEvent;
import com.kinaxis.platform.u202014511.wms.domain.model.valueobjects.InventoryItemStatus;
import com.kinaxis.platform.u202014511.wms.domain.model.valueobjects.KinaxisSku;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * InventoryItem
 * @summary
 * This class represents the InventoryItem aggregate root entity.
 * It contains the information of an inventory item.
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
@Entity
public class InventoryItem extends AuditableAbstractAggregateRoot<InventoryItem> {

    @Embedded
    private KinaxisSku kinaxisSku;

    @NotNull
    private InventoryItemStatus status;

    @Getter
    @NotNull
    @Min(5)
    private Double minimumQuantity;

    @Getter
    @Setter
    @NotNull
    private Double availableQuantity;

    @Getter
    @Setter
    @NotNull
    private Double reservedQuantity;

    @Getter
    @Setter
    @NotNull
    private Double pendingSupplyQuantity;

    protected InventoryItem() {}

    /**
     * Create a new InventoryItem
     * @param command the command to create a new InventoryItem
     * @see CreateInventoryItemCommand
     */
    public InventoryItem(CreateInventoryItemCommand command) {
        this.kinaxisSku = new KinaxisSku(command.kinaxisSku());
        this.status = InventoryItemStatus.AVAILABLE;
        this.minimumQuantity = command.minimumQuantity();
        this.availableQuantity = command.availableQuantity();
        this.reservedQuantity = 0.0;
        this.pendingSupplyQuantity = 0.0;
    }

    public String getKinaxisSku() {
        return kinaxisSku.kinaxisSku();
    }

    public String getStatus() {
        return status.name();
    }

    public void minimumQuantityThresholdReached() {
        this.status = InventoryItemStatus.SUPPLY_NEEDED;
        var requestedSupplyQuantity = minimumQuantity + pendingSupplyQuantity;
        this.registerEvent(new MinimumQuantityThresholdReachedEvent(this, kinaxisSku, requestedSupplyQuantity));
    }

}
