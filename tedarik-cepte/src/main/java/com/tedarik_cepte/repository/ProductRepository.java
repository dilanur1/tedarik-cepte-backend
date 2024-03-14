package com.tedarik_cepte.repository;

import com.tedarik_cepte.models.Fruit;
import com.tedarik_cepte.models.Product;
import com.tedarik_cepte.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * FROM products", nativeQuery = true)
    List<Product> getAllProducts();

    @Query(value = "SELECT * FROM products WHERE category = :category", nativeQuery = true)
    List<Product> getProductsByCategory(@Param("category") String category);
}
