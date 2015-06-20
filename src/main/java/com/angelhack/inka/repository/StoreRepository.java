package com.angelhack.inka.repository;

import java.util.List;

import com.angelhack.inka.common.ItemCategory;
import com.angelhack.inka.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

	@Query("select s from StoreEntity s where s.storeType in :storeTypes")
	public List<StoreEntity> findByStoreTypes(@Param("storeTypes")List<ItemCategory> storeTypes);
}
