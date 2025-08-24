package org.sandha.store.movedCode;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user){
        if (user == null || user.getEmail() == null) {
            throw new IllegalArgumentException("User and user email must not be null");
        }
        System.out.println("Saving user " + user);
        users.put(user.getEmail(), user);
    }

    @Override
    public User findByEmail(String email) {
        return users.getOrDefault(email, null);
    }
}
