package com.angelhack.inka.repository;

import java.util.List;

import com.angelhack.inka.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

	@Query(value="select s from Store_SellCategory sc, StoreEntity s,ItemCategoryEntity i where " +
			"i.name=?1 and i.id=sc.category_Id ans sc.store_Id=s.id", nativeQuery=true)
	public List<StoreEntity> findBycategory(String category);
}
