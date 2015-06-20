package com.angelhack.inka.entity;

import com.angelhack.inka.common.ItemCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */
@Entity
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ElementCollection(targetClass = ItemCategory.class, fetch = FetchType.EAGER)
    private List<ItemCategory> categories;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "WISHLIST_ID")
    private WishlistEntity wishlist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WishlistEntity getWishlist() {
        return wishlist;
    }

    public void setWishlist(WishlistEntity wishlist) {
        this.wishlist = wishlist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ItemCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ItemCategory> categories) {
        this.categories = categories;
    }
}
