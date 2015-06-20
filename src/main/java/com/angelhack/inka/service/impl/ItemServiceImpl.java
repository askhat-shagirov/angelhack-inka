package com.angelhack.inka.service.impl;

import com.angelhack.inka.entity.ItemEntity;
import com.angelhack.inka.entity.UserEntity;
import com.angelhack.inka.repository.ItemRepository;
import com.angelhack.inka.repository.UserRepository;
import com.angelhack.inka.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public void addItem(long userId, ItemEntity item) {
        UserEntity user = userRepository.findOne(userId);
        item.setUser(user);
        user.getItems().add(item);
    }

    @Override
    public List<ItemEntity> getItems(long userId) {
        UserEntity user = userRepository.findOne(userId);
        return user.getItems();
    }

}
