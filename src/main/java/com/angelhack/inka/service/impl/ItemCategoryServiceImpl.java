package com.angelhack.inka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.angelhack.inka.entity.ItemCategoryEntity;
import com.angelhack.inka.repository.ItemCategoryRepository;
import com.angelhack.inka.service.ItemCategoryService;

public class ItemCategoryServiceImpl implements ItemCategoryService {
	@Autowired
	private ItemCategoryRepository itemCategoryRepository;

	@Override
	public List<ItemCategoryEntity> getAll() {
		// TODO Auto-generated method stub
		return itemCategoryRepository.findAll();
	}

	@Override
	public ItemCategoryEntity save(ItemCategoryEntity itemCategoryEntity) {
		return itemCategoryRepository.save(itemCategoryEntity);
	}
	
	public List<ItemCategoryEntity> save(List<ItemCategoryEntity> itemCategoryEntitys) {
		return itemCategoryRepository.save(itemCategoryEntitys);
	}

}
