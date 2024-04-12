package com.tedarik_cepte.services;

import com.tedarik_cepte.models.Cart;
import com.tedarik_cepte.models.CartProduct;
import com.tedarik_cepte.models.Product;
import com.tedarik_cepte.models.User;
import com.tedarik_cepte.repository.CartProductRepository;
import com.tedarik_cepte.repository.CartRepository;
import com.tedarik_cepte.repository.ProductRepository;
import com.tedarik_cepte.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    private UserRepository userRepository;
    

    public void addProductToCart(Long user_id, Long product_id, double quantity) {
        User user = userRepository.findById(user_id).orElseThrow(() -> new NoSuchElementException("User not found"));
        Product product = productRepository.findById(product_id).orElseThrow(() -> new NoSuchElementException("Product not found"));

        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
        }

        CartProduct cartProduct = cartProductRepository.findByCartAndProduct(cart, product);
        if (cartProduct == null) {
            cartProduct = new CartProduct();
            cartProduct.setCart(cart);
            cartProduct.setProduct(product);
            cartProduct.setQuantity(quantity + cartProduct.getQuantity());
        } else {
            cartProduct.setQuantity(quantity + cartProduct.getQuantity());
        }

        cartProductRepository.save(cartProduct);
    }

    public Long getCartIdByUserId(Long user_id) {
        return cartRepository.getCartIdByUserId(user_id);
    }
}
