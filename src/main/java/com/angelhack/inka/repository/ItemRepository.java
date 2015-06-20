package com.angelhack.inka.repository;

import com.angelhack.inka.common.ItemCategory;
import com.angelhack.inka.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    List<ItemEntity> findDistinctByCategoriesInAndBroadcastEquals(List<ItemCategory> categories, boolean b);

    @Query("select distinct item from ItemEntity item join item.categories category where category in :categories and item.broadcast = true")
    List<ItemEntity> findWhereCategoryInAndBroadcastEnabled(
            @Param("categories")
            List<ItemCategory> categories);
}
