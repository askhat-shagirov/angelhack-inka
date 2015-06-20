package com.angelhack.inka.service.impl;

import com.angelhack.inka.entity.UserEntity;
import com.angelhack.inka.repository.UserRepository;
import com.angelhack.inka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public List<UserEntity> getUserList() {
        return userRepository.findAll();
    }

}
