package com.angelhack.inka.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
public class UserAuthority implements GrantedAuthority {

    public static final String USER = "USER";

    @Override
    public String getAuthority() {
        return USER;
    }
}
