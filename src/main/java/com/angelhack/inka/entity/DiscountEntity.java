package com.angelhack.inka.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class DiscountEntity {

	@Id @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    private Double discountedPrice;
    
    /*@ManyToMany
    @JoinTable(name="DiscountTags",
    	      joinColumns={@JoinColumn(name="discountId", referencedColumnName="ID")},
    	      inverseJoinColumns={@JoinColumn(name="tagId", referencedColumnName="ID")})
    private List<TagsEntity> tags;*/
    
    
    @ManyToOne
    @JoinColumn(name = "item_id")  
    private ItemEntity item;
    
    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="seller_id", unique= true, nullable=true, insertable=true, updatable=true)
    private SellerEntity seller;

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

	public SellerEntity getSeller() {
		return seller;
	}

	public void setSeller(SellerEntity seller) {
		this.seller = seller;
	}

	
    
    
}
