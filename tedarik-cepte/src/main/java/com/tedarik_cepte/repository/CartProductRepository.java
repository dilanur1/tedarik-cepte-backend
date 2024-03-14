package com.tedarik_cepte.repository;

import com.tedarik_cepte.models.Cart;
import com.tedarik_cepte.models.CartProduct;
import com.tedarik_cepte.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends CrudRepository<CartProduct, Long> {

    CartProduct findByCartAndProduct(Cart cart, Product product);
}
