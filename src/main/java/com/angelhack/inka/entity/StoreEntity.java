package com.angelhack.inka.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class StoreEntity {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private Double longitude;
    private Double latitude;
    private String address;
    private String storeType;
    
   /* @ManyToMany
    @JoinTable(name="Store_SellCategory",
    	      joinColumns={@JoinColumn(name="store_Id", referencedColumnName="ID")},
    	      inverseJoinColumns={@JoinColumn(name="category_Id", referencedColumnName="ID")})
    private List<ItemCategoryEntity> sellCategories;*/
    

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

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*public List<ItemCategoryEntity> getSellCategories() {
		return sellCategories;
	}

	public void setSellCategories(List<ItemCategoryEntity> sellCategories) {
		this.sellCategories = sellCategories;
	}*/

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
    
    
}
