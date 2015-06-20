package com.angelhack.inka.controller;

import com.angelhack.inka.entity.ItemEntity;
import com.angelhack.inka.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */
@RestController
@RequestMapping("api/user/item/")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ItemEntity> getItems() {
        //TODO get userId
        long userId = 1L;
        return itemService.getItems(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addItem(@RequestBody ItemEntity item) {
        //TODO get userId
        long userId = 1L;
        itemService.addItem(userId, item);
    }

    @RequestMapping(value = "/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
    }


}
