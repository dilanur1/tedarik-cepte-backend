package com.tedarik_cepte.services;

import com.tedarik_cepte.models.Cart;
import com.tedarik_cepte.models.Product;
import com.tedarik_cepte.models.User;
import com.tedarik_cepte.repository.CartRepository;
import com.tedarik_cepte.repository.ProductRepository;
import com.tedarik_cepte.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public void addProductToCart(Long user_id, Long product_id) {
        User user = userRepository.findById(user_id).orElseThrow(() -> new NoSuchElementException("User not found"));
        Product product = productRepository.findById(product_id).orElseThrow(() -> new NoSuchElementException("Product not found"));

        Cart cart = user.getCart() != null ? user.getCart() : new Cart(user);
        cart.addProduct(product);
        cartRepository.save(cart);
    }
}
