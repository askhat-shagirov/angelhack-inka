package com.angelhack.inka.service.impl;

import com.angelhack.inka.entity.TestEntity;
import com.angelhack.inka.repository.TestRepository;
import com.angelhack.inka.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public List<TestEntity> getLatest() {
        return testRepository.findAll();
    }

    @Override
    public TestEntity save(TestEntity test) {
        return testRepository.save(test);
    }
}
