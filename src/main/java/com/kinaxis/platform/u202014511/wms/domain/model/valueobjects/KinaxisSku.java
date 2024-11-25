package com.kinaxis.platform.u202014511.wms.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

/**
 * Value object for Kinaxis SKU
 * @param kinaxisSku the Kinaxis SKU value as a string
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */

@Embeddable
public record KinaxisSku(String kinaxisSku) {
    public KinaxisSku(String kinaxisSku) {
        this.kinaxisSku = UUID.fromString(kinaxisSku).toString();
    }
}
