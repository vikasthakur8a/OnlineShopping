package com.wipro.inventoryms.controller;

import com.wipro.inventoryms.entity.Inventory;
import com.wipro.inventoryms.exception.InventoryNotFoundException;
import com.wipro.inventoryms.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private IInventoryService service;

    @PostMapping("/")
    public ResponseEntity<?> addInventory(@RequestBody Inventory inventory){
        service.addInventory(inventory);
        return new ResponseEntity<>("Inventory Created", HttpStatus.CREATED);
    }

    @GetMapping("/{inventoryId}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable int inventoryId) throws InventoryNotFoundException {
        Inventory inventory = service.searchInventory(inventoryId);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @PutMapping("/{inventoryId}")
    public ResponseEntity<?> updateInventory(@PathVariable int inventoryId,@RequestBody Inventory inventory) throws InventoryNotFoundException{
        service.updateInventory(inventoryId, inventory);
        return new ResponseEntity<>("Inventory Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{inventoryId}")
    public ResponseEntity<?> deleteInventory(@PathVariable int inventoryId) throws InventoryNotFoundException{
        service.deleteInventory(inventoryId);
        return new ResponseEntity<>("Inventory Deleted Successfully", HttpStatus.OK);
    }


}
