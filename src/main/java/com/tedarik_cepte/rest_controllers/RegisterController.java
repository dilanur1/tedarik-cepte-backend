package com.tedarik_cepte.rest_controllers;

import com.tedarik_cepte.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity registerNewUser(@RequestParam("first_name") String first_name,
                                          @RequestParam("last_name") String last_name,
                                          @RequestParam("firm") String firm,
                                          @RequestParam("address") String address,
                                          @RequestParam("phone") String phone,
                                          @RequestParam("username") String username,
                                          @RequestParam("password") String password) {

        String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());


        if (first_name.isEmpty() || firm.isEmpty() || address.isEmpty() || phone.isEmpty() ||
        username.isEmpty() || password.isEmpty()) {
            return new ResponseEntity("Lütfen boş alanları doldurunuz.", HttpStatus.BAD_REQUEST);
        }

        int result = userService.registerNewUserServiceMethod(first_name, last_name,
                firm, address, phone, username, hashed_password);

        if (result != 1) {
           return new ResponseEntity("Kullanıcı kaydedilemedi!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Kullanıcı başarıyla kaydedildi.", HttpStatus.OK);

    }
}
