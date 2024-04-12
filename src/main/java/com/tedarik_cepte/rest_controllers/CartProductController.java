package com.tedarik_cepte.rest_controllers;

import com.tedarik_cepte.services.CartProductService;
import com.tedarik_cepte.services.CartService;
import com.tedarik_cepte.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart_product")
public class CartProductController {
    @Autowired
    CartProductService cartProductService;

    @Autowired
    CartService cartService;

    @GetMapping("/quantity")
    public ResponseEntity getQuantityByUserAndProductId(@RequestParam Long user_id,
                                                        @RequestParam Long product_id) {

        Long cart_id = cartService.getCartIdByUserId(user_id);
        Double quantity = cartProductService.getQuantityByUserAndProductId(cart_id, product_id);
        if(quantity == null) {
            return new ResponseEntity("Hata", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(quantity, HttpStatus.OK);
    }

    @PatchMapping("/quantity")
    public ResponseEntity updateQuantity(@RequestParam Long user_id,
                                         @RequestParam Long product_id,
                                         @RequestBody Double quantity) {

        Long cart_id = cartService.getCartIdByUserId(user_id);
        cartProductService.updateQuantity(cart_id, product_id, quantity);


        return new ResponseEntity("Miktar başarıyla güncellendi.", HttpStatus.OK);
    }
}
