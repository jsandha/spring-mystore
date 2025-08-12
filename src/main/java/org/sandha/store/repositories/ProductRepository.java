package org.sandha.store.repositories;

import org.sandha.store.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}