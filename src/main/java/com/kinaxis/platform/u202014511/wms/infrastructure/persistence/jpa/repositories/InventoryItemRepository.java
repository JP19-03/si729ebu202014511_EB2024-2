package com.kinaxis.platform.u202014511.wms.infrastructure.persistence.jpa.repositories;

import com.kinaxis.platform.u202014511.wms.domain.model.aggregates.InventoryItem;
import com.kinaxis.platform.u202014511.wms.domain.model.valueobjects.KinaxisSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * InventoryItem Repository
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    /**
     * Check if exists by KinaxisSku
     * @param kinaxisSku the KinaxisSku to check
     * @return true if exists, false otherwise
     */
    boolean existsByKinaxisSku(KinaxisSku kinaxisSku);

    /**
     * Find by KinaxisSku
     * @param kinaxisSku the KinaxisSku to find
     * @return the InventoryItem found
     */
    Optional<InventoryItem> findByKinaxisSku(KinaxisSku kinaxisSku);
}
