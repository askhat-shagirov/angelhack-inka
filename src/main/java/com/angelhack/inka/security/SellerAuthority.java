package com.angelhack.inka.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
public class SellerAuthority implements GrantedAuthority {

    public static final String SELLER = "SELLER";

    @Override
    public String getAuthority() {
        return SELLER;
    }

}