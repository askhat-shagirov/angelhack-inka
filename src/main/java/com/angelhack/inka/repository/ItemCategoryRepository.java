package com.angelhack.inka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angelhack.inka.entity.ItemCategoryEntity;


@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategoryEntity, Long> {
}
