package com.angelhack.inka.common;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
public enum ItemCategory {

    bicycle_store,
    book_store,
    clothing_store,
    convenience_store,
    department_store,
    electronics_store,
    furniture_store,
    hardware_store,
    grocery_or_supermarket,
    shopping_mall,
    unknown;
    
    public static ItemCategory getEnum(String val){
    	for(ItemCategory item : ItemCategory.values()){
    		if(item.name().equals(val)){
    			return item;
    		}
    	}
    	return unknown;
    }

}
