package com.angelhack.inka.security.impl;

import com.angelhack.inka.entity.SellerEntity;
import com.angelhack.inka.entity.UserEntity;
import com.angelhack.inka.repository.SellerRepository;
import com.angelhack.inka.repository.UserRepository;
import com.angelhack.inka.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Long getCurrentUserId() {
        return getCurrentUser().getId();
    }

    @Override
    public UserEntity getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return userRepository.findByEmail(authentication.getName());
        return predefinedCurrentUser();
    }

    @Override
    public Long getCurrentSellerId() {
        return getCurrentSeller().getId();
    }

    @Override
    public SellerEntity getCurrentSeller() {
        return predefinedCurrentSeller();
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return sellerRepository.findByEmail(authentication.getName());
    }

    private UserEntity predefinedCurrentUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setEmail("user@mail.com");
        userEntity.setPassword("123");
        userEntity.setFullname("John Doe");
        return userEntity;
    }

    private SellerEntity predefinedCurrentSeller() {
        SellerEntity sellerEntity = new SellerEntity();
        sellerEntity.setId(1L);
        sellerEntity.setEmail("seller@mail.com");
        sellerEntity.setPassword("123");
        sellerEntity.setFullname("Jane Doe");
        return sellerEntity;
    }

}
