package org.sandha.store;

import org.sandha.store.entities.Product;
import org.sandha.store.entities.User;
import org.sandha.store.repositories.UserRepository;
import org.sandha.store.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
        service.createProduct();
        service.createProductFromExistingCategory();
        service.addProductsToUserWishList();
        service.deleteProduct();
       //        var user = new User(1L, "jsandha", "jsandha@gmail.com", "password");
//        var user = User.builder()
//                .id(1L)
//                .name("jsandha")
//                .email("jsandha@gmail.com")
//                .password("satnam")
//                .build();
//
//        var address = Address.builder()
//                .street("123 Main St")
//                .city("city")
//                .state("state")
//                .zip("12345")
//                .build();
//
//        user.addAddress(address);
//
//        user.addTag("tag1");
//        var profile = Profile.builder()
//                .bio("bio")
//                .build();
//        user.setProfile(profile);
//        profile.setUser(user);
//        System.out.println(user.getTags());
//        System.out.println(user);
   }


}
