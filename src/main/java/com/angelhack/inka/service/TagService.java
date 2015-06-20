package com.angelhack.inka.service;

import java.util.List;

import com.angelhack.inka.entity.TagsEntity;


public interface TagService {

    List<TagsEntity> getAll();

    List<TagsEntity> save(List<TagsEntity> tags);
    
}
