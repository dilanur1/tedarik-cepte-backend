package com.tedarik_cepte.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInCart {

    private Long user_id;
    private Long product_id;
    private double quantity;
}
