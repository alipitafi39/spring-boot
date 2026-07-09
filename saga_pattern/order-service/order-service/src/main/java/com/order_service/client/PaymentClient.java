  package com.order_service.client;
  
  import org.springframework.cloud.openfeign.FeignClient; 
  import org.springframework.web.bind.annotation.GetMapping; 
  import org.springframework.web.bind.annotation.PathVariable;
  
  @FeignClient(name = "PAYMENT-SERVICE")
  public interface PaymentClient {

      @GetMapping("/payments/{id}")
      String getPayment(@PathVariable("id") Long id);
  }
 


