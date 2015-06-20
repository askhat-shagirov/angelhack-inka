package com.angelhack.inka.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.angelhack.inka.common.ItemCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    private Boolean gpsNotification;
    private Boolean broadcast;

    @ElementCollection(targetClass = ItemCategory.class, fetch = FetchType.EAGER)
    private List<ItemCategory> categories;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "WISHLIST_ID")
    private WishlistEntity wishlist;
    
    @OneToMany(mappedBy="item")
    private Collection<DiscountEntity> discounts;

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

    public Boolean getGpsNotification() {
        return gpsNotification;
    }

    public void setGpsNotification(Boolean gpsNotification) {
        this.gpsNotification = gpsNotification;
    }

    public Boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(Boolean broadcast) {
        this.broadcast = broadcast;
    }

	public Collection<DiscountEntity> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Collection<DiscountEntity> discounts) {
		this.discounts = discounts;
	}
    
    
}
