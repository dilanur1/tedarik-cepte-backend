package com.tedarik_cepte.models;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vegetables")
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vegetable_id;

    private String category;
    private Double price;
    private int number;
}
