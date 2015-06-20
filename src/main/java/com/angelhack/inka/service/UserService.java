package com.angelhack.inka.service;

import com.angelhack.inka.entity.UserEntity;

import java.util.List;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
public interface UserService {

    void createUser(UserEntity user);

    List<UserEntity> getUserList();
}
