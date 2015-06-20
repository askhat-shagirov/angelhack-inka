package com.angelhack.inka.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelhack.inka.entity.ItemEntity;
import com.angelhack.inka.repository.ItemRepository;
import com.angelhack.inka.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public ItemEntity getItemById(Long itemId) {
		// TODO Auto-generated method stub
		return itemRepository.findOne(itemId);
	}

}
