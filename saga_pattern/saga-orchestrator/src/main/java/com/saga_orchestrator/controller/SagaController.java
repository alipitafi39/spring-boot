package com.saga_orchestrator.controller;

import com.saga_orchestrator.model.OrderRequest;
import com.saga_orchestrator.service.SagaOrchestratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saga")
public class SagaController {

    @Autowired
    private SagaOrchestratorService sagaOrchestratorService;

    @PostMapping("/order")
    public String createOrder(@RequestBody OrderRequest orderRequest) {

    	sagaOrchestratorService.startSaga(orderRequest);

        return "Saga started successfully for Order ID: "
                + orderRequest.getOrderId();
    }
}