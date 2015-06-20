package com.angelhack.inka.service;

import com.angelhack.inka.entity.ItemEntity;

import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */
public interface ItemService {

    void addItem(long userId, ItemEntity item);

    List<ItemEntity> getItems(long userId);

}
