package org.sandha.store.repositories;

import org.sandha.store.dtos.UserSummary;
import org.sandha.store.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllByWishList_Id(Long productId);

    @EntityGraph(attributePaths = {"tags" , "wishList" })
    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = "addresses")
    @Query("select u from User u")
    List<User> findAllWithAddresses();

    @Query("select u.id as id, u.email as email from User u where u.profile.loyaltyPoints >= :points order by  u.email")
    List<UserSummary> findLoyalUsers(@Param("points") int points);
}
