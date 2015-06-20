package com.angelhack.inka.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelhack.inka.entity.TagsEntity;
import com.angelhack.inka.repository.TagRepository;
import com.angelhack.inka.service.TagService;

@Service
@Transactional
public class TagServiceImpl implements TagService{
	
	@Autowired
	TagRepository tagRepository;

	@Override
	public List<TagsEntity> getAll() {
		// TODO Auto-generated method stub
		return tagRepository.findAll();
	}

	@Override
	public List<TagsEntity> save(List<TagsEntity> tags) {
		// TODO Auto-generated method stub
		return tagRepository.save(tags);
	}

}
