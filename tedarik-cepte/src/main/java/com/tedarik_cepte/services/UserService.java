package com.tedarik_cepte.services;

import com.tedarik_cepte.models.User;
import com.tedarik_cepte.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public int registerNewUserServiceMethod(String first_name, String last_name, String firm,
                                            String address, String phone, String username,
                                            String password) {
        return userRepository.registerNewUser(first_name, last_name, firm, address, phone,
                username, password);
    }

    public List<String> checkUsername(String username) {
        return userRepository.checkUsername(username);
    }

    public String checkUserPasswordByUsername(String username) {
        return userRepository.checkUserPasswordByUsername(username);
    }

    public User getUserDetailsByUsername(String username) {
        return userRepository.getUserDetailsByUsername(username);
    }
}
