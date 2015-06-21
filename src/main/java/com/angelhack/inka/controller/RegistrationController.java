package com.angelhack.inka.controller;

import com.angelhack.inka.common.UserType;
import com.angelhack.inka.dto.UserDetailsDto;
import com.angelhack.inka.dto.UserDto;
import com.angelhack.inka.entity.SellerEntity;
import com.angelhack.inka.entity.UserEntity;
import com.angelhack.inka.exception.UnauthorizedException;
import com.angelhack.inka.security.SecurityService;
import com.angelhack.inka.service.SellerService;
import com.angelhack.inka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public void registerUser(@RequestBody UserDto user) {

        if (UserType.BUYER.equals(user.getUserType()))
            userService.createUser(createUserEntity(user));
        else if (UserType.SELLER.equals(user.getUserType()))
            sellerService.createSeller(createSellerEntity(user));
        else
            throw new RuntimeException("Invalid user type");
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public UserDetailsDto getCurrentUserType() throws UnauthorizedException {
        UserEntity user = securityService.getCurrentUser();
        UserDetailsDto dto = new UserDetailsDto();
        if (user != null) {
            dto.setId(user.getId());
            dto.setUserType(UserType.BUYER);
            return dto;
        }

        SellerEntity sellerEntity = securityService.getCurrentSeller();
        if (sellerEntity != null) {
            dto.setId(sellerEntity.getId());
            dto.setUserType(UserType.SELLER);
            return dto;
        }

        throw new UnauthorizedException();
    }


    private SellerEntity createSellerEntity(UserDto user) {
        SellerEntity seller = new SellerEntity();
        seller.setEmail(user.getEmail());
        seller.setPassword(user.getPassword());
        seller.setFullname(user.getName());
        seller.setCategories(user.getCategories());
        return seller;
    }

    private UserEntity createUserEntity(UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setFullname(user.getName());
        return userEntity;
    }

}
