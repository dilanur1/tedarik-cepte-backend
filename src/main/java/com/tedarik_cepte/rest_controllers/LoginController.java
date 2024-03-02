package com.tedarik_cepte.rest_controllers;

import com.tedarik_cepte.models.Login;
import com.tedarik_cepte.models.User;
import com.tedarik_cepte.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public ResponseEntity authenticateUser(@RequestBody Login login) {

        List<String> username = userService.checkUsername(login.getUsername());
        if(username == null || username.isEmpty() ) {
            return new ResponseEntity("Bu kullanıcı adı bulunmamaktadır.", HttpStatus.NOT_FOUND);
        }


        String hashed_password = userService.checkUserPasswordByUsername(login.getUsername());
        if(!BCrypt.checkpw(login.getPassword(), hashed_password)) {
            return new ResponseEntity("Kullanıcı adı veya şifre yanlış.", HttpStatus.BAD_REQUEST);
        }

        User user = userService.getUserDetailsByUsername(login.getUsername());


        return new ResponseEntity(user, HttpStatus.OK);
    }


}
