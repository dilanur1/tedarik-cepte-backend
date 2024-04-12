package com.tedarik_cepte.rest_controllers;

import com.tedarik_cepte.dto.OrderDto;
import com.tedarik_cepte.models.Order;
import com.tedarik_cepte.models.User;
import com.tedarik_cepte.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity addOrder(@RequestBody OrderDto orderDto) {
        User user = orderDto.getUser();
        Double total_price = orderDto.getTotal_price();
        String status = orderDto.getStatus();

        try {
            Order order = orderService.addOrder(user, total_price, status);
            return new ResponseEntity(order, HttpStatus.OK);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sipariş oluşturulurken bir hata oluştu: " + e.getMessage());
        }
    }

}
