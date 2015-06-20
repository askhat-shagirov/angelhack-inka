package com.angelhack.inka.service;

import com.angelhack.inka.entity.TestEntity;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
public interface TestService {

    TestEntity getLatest();

    void save(TestEntity test);
}
