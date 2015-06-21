package com.angelhack.inka.repository;

import com.angelhack.inka.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountEntity, Long> {
	
}
