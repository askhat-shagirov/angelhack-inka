package com.angelhack.inka.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemcategoryStoreTypeMap {

	private static Map<String, List<String>> itemcategoryStoreTypeMaps;
	
	static{
		itemcategoryStoreTypeMaps = new HashMap<String, List<String>>();
		addItemCategoryToStoreType("cloth", "clothing_store","shopping_mall");
		addItemCategoryToStoreType("haircut", "beauty_salon","shopping_mall");
		addItemCategoryToStoreType("sofa", "home_goods_store");
		addItemCategoryToStoreType("milk", "grocery_or_supermarket", "department_store");
		addItemCategoryToStoreType("electronics",  "electronics_store");
		
		
		//itemcategoryStoreTypeMaps.put("cloth", "");
	}
	
	private static void addItemCategoryToStoreType(String itemCat, String... storeTypes){
		List<String> storeTypeList = new ArrayList<String>();
		for(String storeType : storeTypes){
			storeTypeList.add(storeType);			
		}
		itemcategoryStoreTypeMaps.put(itemCat, storeTypeList);
	}
	
	public static List<String> getStoreTypes(String itemCat){
		return itemcategoryStoreTypeMaps.get(itemCat);
	}
}
