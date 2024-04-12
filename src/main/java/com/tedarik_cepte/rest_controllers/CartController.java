package com.tedarik_cepte.rest_controllers;

import com.tedarik_cepte.models.Product;
import com.tedarik_cepte.dto.ProductInCart;
import com.tedarik_cepte.services.CartProductService;
import com.tedarik_cepte.services.CartService;
import com.tedarik_cepte.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    CartProductService cartProductService;

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity addProductToCart(@RequestBody ProductInCart productInCart) {

        Long user_id = productInCart.getUser_id();
        Long product_id = productInCart.getProduct_id();
        double quantity = productInCart.getQuantity();

        cartService.addProductToCart(user_id, product_id, quantity);

        return new ResponseEntity("Ürün sepete eklendi.", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getProductInCartByUserId(@RequestParam Long user_id) {
        Long cart_id = cartService.getCartIdByUserId(user_id);
        if(cart_id == null) {
            return new ResponseEntity("Bu kullanıcıya ait sepet bilgisi bulunmamaktadır.", HttpStatus.NOT_FOUND);
        }

        List<Long> productIdList = cartProductService.getProductIdByCartId(cart_id);
        List<Product> productList = productService.getProductById(productIdList);

        return new ResponseEntity(productList, HttpStatus.OK);
    }

}
