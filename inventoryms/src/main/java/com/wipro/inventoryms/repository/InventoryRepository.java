package com.wipro.inventoryms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.inventoryms.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
