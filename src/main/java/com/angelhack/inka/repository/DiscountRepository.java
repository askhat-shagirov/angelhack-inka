package com.angelhack.inka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.angelhack.inka.entity.DiscountEntity;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountEntity, Long> {
	
	//@Query("select d from DiscountEntity d where d.item_id = :itemId")
	public List<DiscountEntity> findByItemId(@Param("itemId")Long itemId);
}
