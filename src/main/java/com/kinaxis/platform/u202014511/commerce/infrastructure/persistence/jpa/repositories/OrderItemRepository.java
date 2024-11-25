package com.kinaxis.platform.u202014511.commerce.infrastructure.persistence.jpa.repositories;

import com.kinaxis.platform.u202014511.commerce.domain.model.aggregates.OrderItem;
import com.kinaxis.platform.u202014511.commerce.domain.model.valueobjects.InventoryKinaxisSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * OrderItem Repository
 * @author u202014511 Johan Principe Godoy
 * @version 1.0
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    /**
     * Check if exists by order id and kinaxis sku
     * @param orderId the order id
     * @param kinaxisSku the kinaxis sku
     * @return true if exists, false otherwise
     */
    boolean existsByOrderIdAndKinaxisSku(Long orderId, InventoryKinaxisSku kinaxisSku);
}
