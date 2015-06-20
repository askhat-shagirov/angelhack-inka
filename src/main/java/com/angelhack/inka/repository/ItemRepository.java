package com.angelhack.inka.repository;

import com.angelhack.inka.common.ItemCategory;
import com.angelhack.inka.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    List<ItemEntity> findDistinctByCategoriesInAndBroadcastEquals(List<ItemCategory> categories, boolean b);
}
