package com.tedarik_cepte.rest_controllers;

import com.tedarik_cepte.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/addProduct")
    public ResponseEntity addProductToCart(@RequestParam("user_id") Long user_id,
                                           @RequestParam("product_id") Long product_id,
                                           @RequestParam("quantity") double quantity) {
        cartService.addProductToCart(user_id, product_id, quantity);

        return new ResponseEntity("Ürün sepete eklendi.", HttpStatus.OK);
    }
}
