package com.tedarik_cepte.repository;

import com.tedarik_cepte.models.Cart;
import com.tedarik_cepte.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
