package org.sandha.store.services;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.AllArgsConstructor;
import org.sandha.store.entities.Address;
import org.sandha.store.entities.User;
import org.sandha.store.repositories.AddressRepository;
import org.sandha.store.repositories.ProfileRepository;
import org.sandha.store.repositories.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("service")
@Primary
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;

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
}
