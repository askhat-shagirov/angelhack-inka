package com.angelhack.inka.service;

import com.angelhack.inka.entity.TestEntity;

import java.util.List;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
public interface TestService {

    List<TestEntity> getLatest();

    TestEntity save(TestEntity test);
}
