package org.sandha.store;

import org.springframework.stereotype.Service;

@Service("stripe")
public class StripePaymentService implements PaymentService {
    @Override
    public void processPayment(double amount){
        System.out.println("Stripe");
        System.out.println("Amount " + amount);
    }
}
