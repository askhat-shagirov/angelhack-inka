package com.angelhack.inka.controller;

import com.angelhack.inka.entity.TestEntity;
import com.angelhack.inka.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@RestController
@RequestMapping("/hello")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(method = RequestMethod.GET)
    public List<TestEntity> test() {
        return testService.getLatest();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody TestEntity test) {
        testService.save(test);
    }

}
