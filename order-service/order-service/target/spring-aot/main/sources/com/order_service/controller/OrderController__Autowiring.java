package com.order_service.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link OrderController}.
 */
@Generated
public class OrderController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static OrderController apply(RegisteredBean registeredBean, OrderController instance) {
    instance.orderService = AutowiredFieldValueResolver.forRequiredField("orderService").resolve(registeredBean);
    return instance;
  }
}
