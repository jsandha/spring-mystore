package org.sandha.store.movedCode;


public interface UserRepository {
       void save(User user);
       User findByEmail(String email);
}
