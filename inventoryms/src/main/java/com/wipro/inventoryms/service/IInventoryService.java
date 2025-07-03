package com.wipro.inventoryms.service;


import com.wipro.inventoryms.entity.Inventory;
import com.wipro.inventoryms.exception.InventoryNotFoundException;


public interface IInventoryService {
    void addInventory(Inventory inventory);

    Inventory searchInventory(int inventoryId) throws InventoryNotFoundException;

    void updateInventory(int inventoryId, Inventory inventory) throws InventoryNotFoundException;

    void deleteInventory(int inventoryId) throws InventoryNotFoundException;

}
