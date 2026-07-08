package com.order_service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OrderServiceApplication}.
 */
@Generated
public class OrderServiceApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'orderServiceApplication'.
   */
  public static BeanDefinition getOrderServiceApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OrderServiceApplication.class);
    beanDefinition.setInstanceSupplier(OrderServiceApplication::new);
    return beanDefinition;
  }
}
