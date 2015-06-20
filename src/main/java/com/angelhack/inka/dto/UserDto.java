package com.angelhack.inka.dto;

import com.angelhack.inka.common.ItemCategory;
import com.angelhack.inka.common.UserType;

import java.util.List;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
public class UserDto {

    private String email;
    private String password;
    private String name;
    private UserType userType;
    private List<ItemCategory> categories;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<ItemCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ItemCategory> categories) {
        this.categories = categories;
    }
}
