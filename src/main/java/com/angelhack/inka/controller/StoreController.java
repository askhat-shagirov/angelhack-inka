package com.angelhack.inka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angelhack.inka.entity.StoreEntity;
import com.angelhack.inka.service.StoreService;

@RestController
@RequestMapping("/api/user/store/")
public class StoreController {
	
	private static int testId = 1;

    @Autowired
    private StoreService storeService;

    @RequestMapping(value="getAllStores", method = RequestMethod.GET)
    public List<StoreEntity> getAllStores() {
        return storeService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody StoreEntity store) {
        storeService.save(store);
    }
    
    @RequestMapping(value = "testAdd/{storeName}", method = RequestMethod.POST)
    public void testAdd(@PathVariable String storeName) {
    	System.out.println("HI here");
    	StoreEntity se = new StoreEntity();
    	se.setName(storeName);
    	se.setLatitude(1234.0);
    	se.setLongitude(23456.09);
    	se.setAddress("absdfsda");
        storeService.save(se);
    }

}
