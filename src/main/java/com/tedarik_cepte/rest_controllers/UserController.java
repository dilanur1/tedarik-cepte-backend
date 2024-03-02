package com.tedarik_cepte.rest_controllers;

import com.tedarik_cepte.models.User;
import com.tedarik_cepte.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @GetMapping("/test")
    public String testEndpoint() {
        return "başarılı";
    }
}
