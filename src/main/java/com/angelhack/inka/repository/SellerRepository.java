package com.angelhack.inka.repository;

import com.angelhack.inka.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Long> {

    SellerEntity findByEmail(String email);
}
