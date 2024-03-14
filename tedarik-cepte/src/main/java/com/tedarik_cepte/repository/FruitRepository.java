package com.tedarik_cepte.repository;

import com.tedarik_cepte.models.Fruit;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface FruitRepository  extends CrudRepository<Fruit, Long> {

    @Query(value = "SELECT * FROM fruits", nativeQuery = true)
    List<Fruit> getAllFruits();

    @Query(value = "SELECT * FROM fruits WHERE category = :category", nativeQuery = true)
    List<Fruit> getFruitsByCategory(@Param("category") String category);

}
