package org.sandha.store;

import org.sandha.store.entities.Address;
import org.sandha.store.entities.Product;
import org.sandha.store.entities.Profile;
import org.sandha.store.entities.User;
import org.sandha.store.repositories.UserRepository;
import org.sandha.store.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var service =  context.getBean(UserService.class);

//        service.showEntityStates();
//        repository.save(user);
//        service.showRelationshipEntities();
//        service.showRelationship();
//        service.showEntityStates();
//        service.fetchAddress();
//        repository.deleteById(1L);
//        service.persistRelated();
//       repository.deleteAll();
//        service.deleteRelatetedChild();
//        service.createProduct();
//        service.createProductFromExistingCategory();
//        service.addProductsToUserWishList();
//        service.deleteProduct();
//        service.fetchProducts();
//        var user = new User(1L, "jsandha", "jsandha@gmail.com", "password");
//        service.addTagsToUser(user);
//        service.saveUser();
//        service.fetchUsers();
//        service.fetchUsersByEmail();
//        service.findAllWithAddresses();
//        service.findProductsByPrice(BigDecimal.valueOf(1), BigDecimal.valueOf(50));
        service.findProfileGreaterThan(2);
   }



}
