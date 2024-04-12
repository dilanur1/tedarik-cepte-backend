package com.tedarik_cepte.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String category;
    private String name;
    private double price;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<CartProduct> cartProducts;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<OrderItem> orderItems;
}
