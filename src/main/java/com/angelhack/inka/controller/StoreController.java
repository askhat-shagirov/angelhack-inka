package com.angelhack.inka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angelhack.inka.dto.StoreDto;
import com.angelhack.inka.dto.StoreSearchDto;
import com.angelhack.inka.dto.StoreSearchResultDto;
import com.angelhack.inka.entity.ItemCategoryEntity;
import com.angelhack.inka.entity.StoreEntity;
import com.angelhack.inka.service.ItemCategoryService;
import com.angelhack.inka.service.StoreService;

@RestController
@RequestMapping("/api/user/store/")
public class StoreController {
	
	private static int testId = 1;

    @Autowired
    private StoreService storeService;
    
    //@Autowired
    private ItemCategoryService itemCategoryService;
    
    @RequestMapping(value="initTest", method = RequestMethod.GET)
    public void initTest() {
    	//List<ItemCategoryEntity> itemcats = createItemcategories(new String[]{"electronics", "cloth","grocery"});
    	
    	createStore("Wallmart", 226789.04, 24580.9, "Nanshan,  Houhai", "grocery_or_supermarket");
    	createStore("FoodMarket", 226785.04, 24580.9, "Nanshan,  Houhai", "grocery_or_supermarket");
    	createStore("Sunning", 226783.04, 24580.9, "Nanshan,  Houhai", "electronics_store");
    	createStore("CoastalCity", 226781.04, 24580.9, "Nanshan,  Houhai", "shopping_mall");
    	System.out.println("Test init complete");
    }
    
    @RequestMapping(value="getSearchReq", method = RequestMethod.GET)
    public StoreSearchDto getSearchReq() {
    	StoreSearchDto s = new StoreSearchDto();
    	s.setItemCat("electronics");
    	s.setLat(24580.9);
    	s.setLon(26780.04);
    	s.setRadius(100);
    
    	return s;
    }
    
    
    private StoreEntity createStore(String name, double lon, double lat, String address, String storeType){
    	StoreEntity se = new StoreEntity();
    	se.setName(name);
    	se.setLatitude(lat);
    	se.setLongitude(lon);
    	se.setAddress(address);
    	se.setStoreType(storeType);
    	//se.setSellCategories(createItemcategories(categs));
    	storeService.save(se);
    	return se;
    }
    
    private List<ItemCategoryEntity> createItemcategories(String[] types){
    	//String[] types = new String[]{"shopping_mall", "pet_store","grocery_or_supermarket"};
    	List<ItemCategoryEntity> itemcats = new ArrayList<ItemCategoryEntity>();
    	ItemCategoryEntity currItemCat = null;
    	for(String type : types){
    		currItemCat = new ItemCategoryEntity();
    		currItemCat.setName(type);
    		itemcats.add(currItemCat);
    		
    	}
    	itemCategoryService.save(itemcats);
    	return itemcats;
    }

    @RequestMapping(value="getAllStores", method = RequestMethod.GET)
    public StoreSearchResultDto getAllStores() {
        return convert(storeService.getAll());
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
    
    @RequestMapping(value = "findNearByStores", method = RequestMethod.POST)
    public StoreSearchResultDto findNearByStores(@RequestParam String lon, @RequestParam String lat, @RequestParam String itemCat, @RequestParam String radius){
    	List<StoreEntity> stores = storeService.findNearByStores(Double.valueOf(lon), Double.valueOf(lat), itemCat, Double.valueOf(radius));
    	//List<StoreEntity> stores = storeService.findNearByStores(storeSearchDto.getLon(), storeSearchDto.getLat(), storeSearchDto.getItemCat(), storeSearchDto.getRadius());
    	return convert(stores);
    }
    
    public StoreSearchResultDto convert(List<StoreEntity> stores){
    	StoreSearchResultDto searchResultDto = new StoreSearchResultDto();
    	for(StoreEntity store : stores){
    		searchResultDto.addStore(new StoreDto(store));
    	}
    	return searchResultDto;
    }
    

}
