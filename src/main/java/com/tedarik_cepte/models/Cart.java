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
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "cart_product", joinColumns = @JoinColumn(name = "cart_id") , inverseJoinColumns = @JoinColumn(name = "product_id") )
    private Set<Product> products;

    public Cart(User user) {
    }

    public void addProduct(Product product) {
    }
}
