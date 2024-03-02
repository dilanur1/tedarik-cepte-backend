package com.tedarik_cepte.repository;

import com.tedarik_cepte.models.Fruit;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository  extends CrudRepository<Fruit, Long> {

    //@Query(value = "SELECT * FROM fruits WHERE category = :category", nativeQuery = true);

}
