package com.wipro.shoppingms.repository;

import com.wipro.shoppingms.entity.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "inventoryms", url = "http://localhost:8083/api/inventory")
public interface InventoryRepo {
    @PostMapping("/")
    void addInventory(@RequestBody Inventory inventory);

    @GetMapping("/{inventoryId}")
    Inventory getInventoryById(@PathVariable int inventoryId);

    @PutMapping("/{inventoryId}")
    void updateInventory(@PathVariable int inventoryId,@RequestBody Inventory inventory);

    @DeleteMapping("/{inventoryId}")
    void deleteInventory(@PathVariable int inventoryId);
}
