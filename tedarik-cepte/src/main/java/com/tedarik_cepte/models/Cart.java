package com.tedarik_cepte.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.*;


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
    private Long cart_id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ElementCollection
    @CollectionTable(name = "cart_product", joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Product, Double> products = new HashMap<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<CartProduct> cartProducts;



    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart_id);
    }
}
