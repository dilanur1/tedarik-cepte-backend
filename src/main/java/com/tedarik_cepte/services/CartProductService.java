package com.tedarik_cepte.services;

import com.tedarik_cepte.repository.CartProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartProductService {

    @Autowired
    private CartProductRepository cartProductRepository;

    public List<Long> getProductIdByCartId(Long cart_id) {

        return cartProductRepository.getProductIdByCartId(cart_id);
    }

    public Double getQuantityByUserAndProductId(Long cart_id, Long product_id) {

        return cartProductRepository.getQuantityByUserAndProductId(cart_id, product_id);
    }

    public void updateQuantity(Long cart_id, Long product_id, Double quantity) {

        cartProductRepository.updateQuantity(cart_id, product_id, quantity);
    }
}
