package com.tedarik_cepte.rest_controllers;

import com.tedarik_cepte.models.Product;
import com.tedarik_cepte.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity getProductsByCategory(@RequestParam("category") String category) {
        List<Product> productList;

        if (category == null || category.isEmpty()) {
             productList = productService.getAllProducts();

            if(productList == null || productList.isEmpty()) {
                return new ResponseEntity("Ürün bulunmamaktadır.", HttpStatus.NOT_FOUND);
            }
        }else {
            productList = productService.getProductsByCategory(category);
            if(productList == null || productList.isEmpty()) {
                return new ResponseEntity(category + " bulunamadı.", HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity(productList, HttpStatus.OK);

    }
}
