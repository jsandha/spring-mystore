package org.sandha.store.services;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.sandha.store.entities.*;
import org.sandha.store.repositories.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service("service")
@Primary
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void showEntityStates() {
        var user = User.builder()
                .email("abc@gmail.com")
                .password("1234")
                .name("abc")
                .build();


        if (entityManager.contains(user))
            System.out.println("Persistent");
        else System.out.println("Transient/ Detached");

        userRepository.save(user);


        if(entityManager.contains(user))
            System.out.println("Persistent");
        else System.out.println("Transient/ Detached");
    }

    public void showRelationshipEntities(){
        var user = userRepository.findById(5L).orElseThrow();
        System.out.println(user.getEmail());
    }

    @Transactional
    public void showRelationship(){
        profileRepository.findById(5L).ifPresent(profile -> {
            System.out.println("Profile: " + profile);
            System.out.println("User: " + profile.getUser());
        });
    }

    public void fetchAddress(){
        addressRepository.findById(5L).ifPresent(address -> {
            System.out.println("Address: " + address);
            System.out.println("User: " + address.getUser());
        });
    }

    @Transactional
    public void saveUser(){
        var user = User.builder()
            .name("jsandha")
            .email("jsandha@gmail.com")
            .password("123")
            .build();

        var address = Address.builder()
                .street("123 Main St")
                .city("city")
                .state("state")
                .zip("12345")
                .build();

        user.addAddress(address);

        user.addTag("tag1");

        var profile = Profile.builder()
                .bio("bio")
                .build();

        user.setProfile(profile);

        profile.setUser(user);
        userRepository.save(user);
    }

    public void persistRelated(){
        var user = User.builder()
                .email("abc@gmail.com")
                .password("123")
                .name("abc")
                .build();
        var address = Address.builder()
                .street("123 Main St")
                .city("city")
                .zip("12345")
                .state("state")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    public void deletedRelatedParent(){
        userRepository.deleteById(5L);
    }

    @Transactional
    public void deleteRelatetedChild(){
       var user = userRepository.findById(10L).orElseThrow();
       var address = user.getAddresses().getFirst();
       user.removeAddress(address);
       userRepository.save(user);
    }


    public void createProduct(){
        var product = Product.builder()
                .name("product")
                .price(BigDecimal.valueOf(100))
                .description("description")
                .build();

        var category = Category.builder()
                .name("category")
                .build();

        product.setCategory(category);

        productRepository.save(product);

    }
    @Transactional
    public void createProductFromExistingCategory(){
        var category = categoryRepository.findById((byte) 1).orElseThrow();
        if(category == null){
            throw new IllegalArgumentException("Category not found");
        }

        var product = Product.builder()
                .name("product2")
                .price(BigDecimal.valueOf(200))
                .description("description2")
                .category((Category) category)
                .build();

        productRepository.save(product);
    }@Transactional
   public void addProductsToUserWishList(){
        var user = userRepository.findById(10L).orElseThrow();
        var products = productRepository.findAll();

        products.forEach(user::addFavouriteProduct);
        userRepository.save(user);
   }

    @Transactional
    public void deleteProduct(){
        Long productId = 6L;

        // Load the product; fail early if it doesn't exist
        var product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: id=" + productId));

        // Remove associations from all users' wishlists
        List<User> usersWithProduct = userRepository.findAllByWishList_Id(productId);
        for (User u : usersWithProduct) {
            u.getWishList().remove(product);
        }
        if (!usersWithProduct.isEmpty()) {
            userRepository.saveAll(usersWithProduct);
        }

        // Now safe to delete the product
        productRepository.delete(product);
    }
        public void fetchProducts(){
       var product = productRepository.findByCategory(new Category((byte) 1));
            System.out.println(product);
    }

}
