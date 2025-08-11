package org.sandha.store.services;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.sandha.store.entities.User;
import org.sandha.store.repositories.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("service")
@Primary
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

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
}
