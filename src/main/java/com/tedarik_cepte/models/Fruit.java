package com.tedarik_cepte.models;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fruits")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fruit_id;

    private String category;
    private Double price;
    private int number;
}
