package com.tedarik_cepte.repository;

import com.tedarik_cepte.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT username FROM users WHERE username = :username", nativeQuery = true)
    List<String> checkUsername(@Param("username") String username);

    @Query(value = "SELECT password FROM users WHERE username = :username", nativeQuery = true)
    String checkUserPasswordByUsername(@Param("username") String username);

    @Query(value = " SELECT * FROM users WHERE username = :username", nativeQuery = true)
    User getUserDetailsByUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO USERS(first_name, last_name, firm, address, phone, username, password, role) VALUES(:first_name, :last_name, :firm, :address, :phone, :username, :password, :role)", nativeQuery = true)
    int registerNewUser(@Param("first_name") String first_name,
                        @Param("last_name") String last_name,
                        @Param("firm") String firm,
                        @Param("address") String address,
                        @Param("phone") String phone,
                        @Param("username") String username,
                        @Param("password") String password,
                        @Param("role") String role);

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<User> getUsers();
}
