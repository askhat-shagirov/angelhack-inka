package com.angelhack.inka.controller;

import com.angelhack.inka.entity.UserEntity;
import com.angelhack.inka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public void registerUser(@RequestBody UserEntity user) {
        userService.createUser(user);
    }

}
