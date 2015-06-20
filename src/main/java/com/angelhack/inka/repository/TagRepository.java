package com.angelhack.inka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angelhack.inka.entity.TagsEntity;

@Repository
public interface TagRepository extends JpaRepository<TagsEntity, Long> {
}
