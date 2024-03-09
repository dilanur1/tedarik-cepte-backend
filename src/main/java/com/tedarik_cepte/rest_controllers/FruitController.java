package com.tedarik_cepte.rest_controllers;

import com.tedarik_cepte.models.Fruit;
import com.tedarik_cepte.services.FruitService;
import com.tedarik_cepte.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class FruitController {

    @Autowired
    FruitService fruitService;

    @GetMapping("/fruit")
    public ResponseEntity getFruitsByCategory(@RequestParam(required = false) String category) {
        List<Fruit> fruitList;

        if (category == null || category.isEmpty()) {
            fruitList = fruitService.getAllFruits();

            if(fruitList == null || fruitList.isEmpty()) {
                return new ResponseEntity("Meyve bulunamadı.", HttpStatus.NOT_FOUND);
            }
        }else {
            fruitList = fruitService.getFruitsByCategory(category);
            if(fruitList == null || fruitList.isEmpty()) {
                return new ResponseEntity("Meyve bulunamadı.", HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity(fruitList, HttpStatus.OK);
    }



}
