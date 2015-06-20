package com.angelhack.inka.security;

import com.angelhack.inka.common.UserType;
import com.angelhack.inka.entity.SellerEntity;
import com.angelhack.inka.entity.UserEntity;
import com.angelhack.inka.repository.SellerRepository;
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

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        if (user != null) return createUserCredentials(user);

        SellerEntity seller = sellerRepository.findByEmail(email);
        if(seller != null) return createSellerCredentials(seller);

        throw new UsernameNotFoundException("No user found with given credentials");
    }

    private UserDetails createUserCredentials(UserEntity user) {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new BuyerAuthority());
        return new User(user.getEmail(), user.getPassword(), true, true, true, true, authorities);
    }

    private UserDetails createSellerCredentials(SellerEntity seller) {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SellerAuthority());
        return new User(seller.getEmail(), seller.getPassword(), true, true, true, true, authorities);
    }

}
