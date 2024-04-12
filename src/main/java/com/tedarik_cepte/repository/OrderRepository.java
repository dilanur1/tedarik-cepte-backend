package com.tedarik_cepte.repository;

import com.tedarik_cepte.models.CartProduct;
import com.tedarik_cepte.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
