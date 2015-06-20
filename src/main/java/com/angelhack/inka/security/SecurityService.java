package com.angelhack.inka.security;

import com.angelhack.inka.entity.SellerEntity;
import com.angelhack.inka.entity.UserEntity;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
public interface SecurityService {

    Long getCurrentUserId();

    UserEntity getCurrentUser();

    Long getCurrentSellerId();

    SellerEntity getCurrentSeller();
}
