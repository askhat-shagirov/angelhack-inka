package com.angelhack.inka.service.impl;

import com.angelhack.inka.entity.SellerEntity;
import com.angelhack.inka.repository.SellerRepository;
import com.angelhack.inka.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public void createSeller(SellerEntity seller) {
        sellerRepository.save(seller);
    }
}
