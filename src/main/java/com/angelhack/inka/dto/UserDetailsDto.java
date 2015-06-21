package com.angelhack.inka.dto;

import com.angelhack.inka.common.UserType;

/**
 * Created by Askhat_Shagirov on 21-Jun-15.
 */
public class UserDetailsDto {

    private Long id;
    private UserType userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
