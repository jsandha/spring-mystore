package org.sandha.store.repositories;

import org.sandha.store.dtos.ProductSummary;
import org.sandha.store.dtos.ProductSummaryDtos;
import org.sandha.store.entities.Category;
import org.sandha.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p.id, p.name from Product p where p.category = :category")
    List<ProductSummaryDtos> findByCategory(@Param("category") Category category);

    @Procedure("findProductsByPrice")
    List<Product> findProductsByPrice(BigDecimal min, BigDecimal max);
}