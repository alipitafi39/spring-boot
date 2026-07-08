package com.order_service.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OrderService}.
 */
@Generated
public class OrderService__BeanDefinitions {
  /**
   * Get the bean definition for 'orderService'.
   */
  public static BeanDefinition getOrderServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OrderService.class);
    beanDefinition.setInstanceSupplier(OrderService::new);
    return beanDefinition;
  }
}
