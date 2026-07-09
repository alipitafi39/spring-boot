package com.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.order_service.client.PaymentClient;
import com.order_service.model.OrderRequest;
import com.order_service.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
    @Autowired
    private PaymentClient paymentClient;
    
    @Autowired
    private OrderService orderService;

//    @GetMapping("/{id}")
//    public String getOrder(@PathVariable String id) {
//        return "Order Service -> Order ID: " + id;
//    }

    @GetMapping
    public String allOrders() {
        return "Order Service -> All Orders";
    }
    


    @GetMapping("/{id}")
    public String getOrder(@PathVariable Long id) {
        String payment = paymentClient.getPayment(id);
        return "Order ID: " + id + " | " + payment;
    }
    
    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest request) {

        orderService.createOrder(request);

        return ResponseEntity.ok("Order created successfully.");
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable String orderId) {

        orderService.cancelOrder(orderId);

        return ResponseEntity.ok("Order cancelled successfully.");
    }
}
