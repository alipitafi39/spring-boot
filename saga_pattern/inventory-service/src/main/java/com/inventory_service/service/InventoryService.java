package com.inventory_service.service;

import com.inventory_service.model.InventoryRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InventoryService {

    private final Map<String, Integer> inventory = new HashMap<>();

    public InventoryService() {
        inventory.put("P001", 10);
        inventory.put("P002", 20);
        inventory.put("P003", 15);
    }

    public String reserve(InventoryRequest request) {

        Integer available = inventory.get(request.getProductId());

        if (available == null || available < request.getQuantity()) {
            throw new RuntimeException("Insufficient inventory");
        }

        inventory.put(
                request.getProductId(),
                available - request.getQuantity()
        );

        return "Inventory Reserved";
    }

    public String rollback(String productId, int quantity) {

        inventory.put(
                productId,
                inventory.getOrDefault(productId, 0) + quantity
        );

        return "Inventory Restored";
    }
}