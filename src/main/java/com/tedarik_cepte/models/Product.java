package com.tedarik_cepte.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


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
    private Double price;


    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private Set<Cart> carts;
}
