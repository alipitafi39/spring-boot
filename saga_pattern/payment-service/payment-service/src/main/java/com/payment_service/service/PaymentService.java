package com.payment_service.service;

import com.payment_service.model.PaymentRequest;

public class PaymentService {

    public String makePayment(PaymentRequest request) {

        if (request.getAmount() > 1000) {
            throw new RuntimeException("💥 Payment failed - Insufficient balance");
        }

        System.out.println("Payment Successful for Order : " + request.getOrderId());

        return "PAYMENT_SUCCESS";
    }

    public String refundPayment(String orderId) {

        System.out.println("Refund initiated for Order : " + orderId);

        return "PAYMENT_REFUNDED";
    }
}