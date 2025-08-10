package org.sandha.store;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public UserService(NotificationService notificationService, UserRepository userRepository) {
        this.notificationService = notificationService;
        this.userRepository = userRepository;
    }

    public void registerUser(User user){
        if(this.userRepository.findByEmail(user.getEmail()) != null){
            throw new IllegalArgumentException("User already exists");
        }

        this.userRepository.save(user);
        this.notificationService.send("Welcome to the store", user.getEmail());
    }
}
