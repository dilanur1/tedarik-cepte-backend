package com.tedarik_cepte.services;

import com.tedarik_cepte.models.Fruit;
import com.tedarik_cepte.models.Product;
import com.tedarik_cepte.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
