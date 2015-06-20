package com.angelhack.inka.controller;

import com.angelhack.inka.entity.TestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@RestController
@RequestMapping("/hello")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public TestEntity test() {
        TestEntity ent = new TestEntity();
        ent.setId(123L);
        ent.setName("Name");
        return ent;
    }

}
