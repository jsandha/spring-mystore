package org.sandha.store.repositories;

import org.sandha.store.entities.Wishlist;
import org.sandha.store.entities.WishlistId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface WishlistRepository extends CrudRepository<Wishlist, WishlistId> {
}