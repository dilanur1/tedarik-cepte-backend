package com.tedarik_cepte.repository;

import com.tedarik_cepte.models.Cart;
import com.tedarik_cepte.models.Product;
import com.tedarik_cepte.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    @Query(value = "SELECT cart_id FROM cart WHERE user_id = :user_id", nativeQuery = true)
    Long getCartIdByUserId(@Param("user_id") Long user_id);


}
