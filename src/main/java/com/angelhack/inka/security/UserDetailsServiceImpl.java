package com.angelhack.inka.security;

import com.angelhack.inka.common.UserType;
import com.angelhack.inka.entity.UserEntity;
import com.angelhack.inka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();

        if (UserType.BUYER.equals(user.getUserType()))
            authorities.add(new BuyerAuthority());
        else if (UserType.SELLER.equals(user.getUserType()))
            authorities.add(new SellerAuthority());

        return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
    }

}
