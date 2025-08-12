package org.sandha.store.repositories;

import org.sandha.store.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
    Object getCategoriesById(Byte id);
}