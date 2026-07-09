package com.saga_orchestrator.service;


import com.saga_orchestrator.model.OrderRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SagaOrchestratorService {

    private final RestTemplate restTemplate = new RestTemplate();

    public void startSaga(OrderRequest orderRequest) {
        try {
            // Step 1: Create Order
            restTemplate.postForObject(
                    "http://localhost:8081/orders",
                    orderRequest,
                    String.class
            );

            // Step 2: Process Payment
            restTemplate.postForObject(
                    "http://localhost:8082/payments",
                    orderRequest,
                    String.class
            );

            // Step 3: Reserve Inventory
            restTemplate.postForObject(
                    "http://localhost:8083/inventory",
                    orderRequest,
                    String.class
            );

            System.out.println("Saga completed successfully for Order: "
                    + orderRequest.getOrderId());

        } catch (Exception ex) {
            System.out.println("Saga failed for Order: "
                    + orderRequest.getOrderId());

            compensate(orderRequest);
        }
    }

    private void compensate(OrderRequest orderRequest) {

        try {
            restTemplate.postForObject(
                    "http://localhost:8083/inventory/rollback/" + orderRequest.getOrderId(),
                    null,
                    String.class
            );
        } catch (Exception ignored) {
        }

        try {
            restTemplate.postForObject(
                    "http://localhost:8082/payments/refund/" + orderRequest.getOrderId(),
                    null,
                    String.class
            );
        } catch (Exception ignored) {
        }

        try {
            restTemplate.postForObject(
                    "http://localhost:8081/orders/cancel/" + orderRequest.getOrderId(),
                    null,
                    String.class
            );
        } catch (Exception ignored) {
        }

        System.out.println("Compensation completed for Order: "
                + orderRequest.getOrderId());
    }
}