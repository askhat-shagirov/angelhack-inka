package com.angelhack.inka.controller;

import com.angelhack.inka.entity.UserEntity;
import com.angelhack.inka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@RestController
@RequestMapping(value = "api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserEntity> getUserList() {
        return userService.getUserList();
    }
}
