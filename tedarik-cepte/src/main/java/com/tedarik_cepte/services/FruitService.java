package com.tedarik_cepte.services;

import com.tedarik_cepte.models.Fruit;
import com.tedarik_cepte.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    @Autowired
    FruitRepository fruitRepository;

    public List<Fruit> getFruitsByCategory(String category) {
        return fruitRepository.getFruitsByCategory(category);
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.getAllFruits();
    }
}
