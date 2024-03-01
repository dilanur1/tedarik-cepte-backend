package com.tedarik_cepte.repository;

import com.tedarik_cepte.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO USERS(first_name, last_name, firm, address, phone, username, password) VALUES(:first_name, :last_name, :firm, :address, :phone, :username, :password)", nativeQuery = true)
    int registerNewUser(@Param("first_name") String first_name,
                        @Param("last_name") String last_name,
                        @Param("firm") String firm,
                        @Param("address") String address,
                        @Param("phone") String phone,
                        @Param("username") String username,
                        @Param("password") String password);
}
