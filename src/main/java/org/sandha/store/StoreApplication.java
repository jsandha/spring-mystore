package org.sandha.store;

import org.sandha.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
//       ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var user = new User(1L, "jsandha", "jsandha@gmail.com", "password");

   }


}
