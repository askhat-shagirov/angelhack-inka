package com.angelhack.inka.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
public class BuyerAuthority implements GrantedAuthority {

    public static final String BUYER = "BUYER";

    @Override
    public String getAuthority() {
        return BUYER;
    }
}
