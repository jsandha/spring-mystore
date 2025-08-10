package org.sandha.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {
    @Value("${payment-gateway:stripe}")
    private String paymentGateway;
    @Bean
    public PaymentService paypal(){
        return new PayPalPaymentService();
    }

    @Bean
    public PaymentService stripe(){
        return new StripePaymentService();
    }

    @Bean
    public OrderService orderService(){
        if(paymentGateway.equalsIgnoreCase("paypal")){
            return new OrderService(paypal());
        }
        return new OrderService(stripe());
    }
    @Bean
    @Lazy
    public HeavyResource heavyResource(){
        return new HeavyResource();
    }
}
