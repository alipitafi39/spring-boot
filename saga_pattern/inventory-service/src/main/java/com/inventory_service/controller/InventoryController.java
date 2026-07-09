package com.inventory_service.controller;

import com.inventory_service.model.InventoryRequest;
import com.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public String reserveInventory(@RequestBody InventoryRequest request) {
        return inventoryService.reserve(request);
    }

    @PostMapping("/rollback/{productId}/{quantity}")
    public String rollbackInventory(
            @PathVariable String productId,
            @PathVariable int quantity) {

        return inventoryService.rollback(productId, quantity);
    }
}