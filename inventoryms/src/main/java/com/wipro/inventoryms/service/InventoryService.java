package com.wipro.inventoryms.service;

import com.wipro.inventoryms.entity.Inventory;
import com.wipro.inventoryms.exception.InventoryNotFoundException;
import com.wipro.inventoryms.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService implements IInventoryService{

    @Autowired
    private InventoryRepository repo;

    @Override
    public void addInventory(Inventory inventory) {
        repo.save(inventory);
    }

    @Override
    public Inventory searchInventory(int inventoryId) throws InventoryNotFoundException{
        Inventory product= repo.findById(inventoryId)
                .orElseThrow(() -> new InventoryNotFoundException("No inventory found with id : " + inventoryId));
        return product;
    }

    @Override
    public void updateInventory(int inventoryId,Inventory inventory) throws InventoryNotFoundException {
        Inventory existingInventory = repo.findById(inventoryId)
                .orElseThrow(() -> new InventoryNotFoundException("No inventory found with id : " + inventoryId));
        existingInventory.setProductId(inventory.getProductId());
        existingInventory.setQuantity(inventory.getQuantity());
        repo.save(existingInventory);
    }

    @Override
    public void deleteInventory(int inventoryId) throws InventoryNotFoundException {
        Inventory inventory = repo.findById(inventoryId)
                .orElseThrow(() -> new InventoryNotFoundException("No inventory found with id : " + inventoryId));
        repo.delete(inventory);
    }

}
