package org.sandha.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
      var notificationManager =  context.getBean(NotificationManager.class);
//        OrderService orderService = new OrderService(new StripePaymentService());
//        OrderService orderService = new OrderService(new PayPalPaymentService());
//        OrderService orderService = new OrderService();
//       orderService.setPaymentService(new PayPalPaymentService());
//     orderService.placeOrder();
        notificationManager.sendNotification("Order Placed");
   }


}
