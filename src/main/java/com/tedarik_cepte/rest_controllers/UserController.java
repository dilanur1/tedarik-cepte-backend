package com.tedarik_cepte.rest_controllers;

import com.tedarik_cepte.models.User;
import com.tedarik_cepte.repository.UserRepository;
import com.tedarik_cepte.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity getUsers() {
        List<User> userList = userService.getUsers();

        if(userList == null || userList.isEmpty()) {
            return new ResponseEntity("Kullanıcı listesi boş!", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(userList, HttpStatus.OK);
    }
}
