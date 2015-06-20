package com.angelhack.inka.dto;

import com.angelhack.inka.common.ItemCategory;

import java.util.List;

/**
 * Created by Askhat_Shagirov on 21-Jun-15.
 */
public class WishDto {

    private Long itemId;
    private String name;
    private List<ItemCategory> categories;
    private Long quantity;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ItemCategory> categories) {
        this.categories = categories;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }
}
