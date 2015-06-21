package com.angelhack.inka.security.impl;

import com.angelhack.inka.entity.SellerEntity;
import com.angelhack.inka.entity.UserEntity;
import com.angelhack.inka.repository.SellerRepository;
import com.angelhack.inka.repository.UserRepository;
import com.angelhack.inka.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByEmail(authentication.getName());
    }

    @Override
    public Long getCurrentSellerId() {
        return getCurrentSeller().getId();
    }

    @Override
    public SellerEntity getCurrentSeller() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return sellerRepository.findByEmail(authentication.getName());
    }

}
