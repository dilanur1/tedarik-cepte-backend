package com.tedarik_cepte.repository;

import com.tedarik_cepte.models.Product;
import com.tedarik_cepte.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
