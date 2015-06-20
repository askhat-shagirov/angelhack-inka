package com.angelhack.inka.service.impl;

import com.angelhack.inka.entity.TestEntity;
import com.angelhack.inka.service.TestService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Override
    public TestEntity getLatest() {
        TestEntity ent = new TestEntity();
        ent.setId(123L);
        ent.setName("Name");
        return ent;
    }

    @Override
    public void save(TestEntity test) {
        System.out.println("Saved!");
    }
}
