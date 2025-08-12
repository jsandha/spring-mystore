package org.sandha.store.repositories;

import org.sandha.store.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllByWishList_Id(Long productId);
}
