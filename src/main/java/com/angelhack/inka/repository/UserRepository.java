package com.angelhack.inka.repository;

import com.angelhack.inka.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.LongSummaryStatistics;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
