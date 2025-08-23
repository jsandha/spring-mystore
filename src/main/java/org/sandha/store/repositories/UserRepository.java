package org.sandha.store.repositories;

import org.sandha.store.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllByWishList_Id(Long productId);

    @EntityGraph(attributePaths = "tags")
    Optional<User> findByEmail(String email);
}
