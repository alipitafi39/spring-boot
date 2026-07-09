package com.order_service.service;

import com.order_service.model.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    private final Map<String, OrderRequest> orders = new HashMap<>();

    public String createOrder(OrderRequest request) {

        orders.put(request.getOrderId(), request);

        return "Order Created Successfully";
    }

    public String cancelOrder(String orderId) {

        orders.remove(orderId);

        return "Order Cancelled Successfully";
    }

    public OrderRequest getOrder(String orderId) {

        return orders.get(orderId);
    }
}