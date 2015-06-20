package com.angelhack.inka.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelhack.inka.entity.DiscountEntity;
import com.angelhack.inka.repository.DiscountRepository;
import com.angelhack.inka.service.DiscountService;

@Service
@Transactional
public class DiscountServiceImpl implements DiscountService{

	@Autowired
	DiscountRepository discountRepository;
	
	@Override
	public List<DiscountEntity> getAll() {
		// TODO Auto-generated method stub
		return discountRepository.findAll();
	}

	@Override
	public List<DiscountEntity> save(List<DiscountEntity> discounts) {
		// TODO Auto-generated method stub
		return discountRepository.save(discounts);
	}

	@Override
	public DiscountEntity save(DiscountEntity discount) {
		// TODO Auto-generated method stub
		return discountRepository.save(discount);
	}
	
	@Override
	public List<DiscountEntity>  findDiscountsByItemId(Long itemId){
		return discountRepository.findByItemId(itemId);
	}

	public DiscountRepository getDiscountRepository() {
		return discountRepository;
	}

	public void setDiscountRepository(DiscountRepository discountRepository) {
		this.discountRepository = discountRepository;
	}
	
	

}
