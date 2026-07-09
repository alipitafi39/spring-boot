package com.payment_service.controller;

import org.springframework.web.bind.annotation.*;
import com.payment_service.model.PaymentRequest;
import com.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	 @Autowired
	 private PaymentService paymentService;

    @GetMapping("/{id}")
    public String getPayment(@PathVariable Long id) {
        return "Payment details for id: " + id;
    }    
   
    @PostMapping("/pay")
    public ResponseEntity<String> makePayment(@RequestBody PaymentRequest orderRequest) {
        return ResponseEntity.ok(paymentService.makePayment(orderRequest));
    }

    @PostMapping("/refund/{paymentId}")
    public ResponseEntity<String> refundPayment(@PathVariable String paymentId) {
        return ResponseEntity.ok(paymentService.refundPayment(paymentId));
    }
}
