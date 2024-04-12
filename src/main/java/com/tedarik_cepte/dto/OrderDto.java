package com.tedarik_cepte.dto;

import com.tedarik_cepte.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    private User user;
    private Double total_price;
    private String status;
}
