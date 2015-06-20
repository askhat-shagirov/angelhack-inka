package com.angelhack.inka.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class StoreDiscountEntity {

	 @Id
	    private Long id;
	    private String name;
	    
	    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	    @JoinColumn(name="STORE_ID", nullable=false)
	    private StoreEntity store;
	    
	    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	    @JoinColumn(name="CATEGORY_ID", nullable=false)
	    private ItemCategoryEntity itemCategory;
	    
	    private double actualPrice;
	    private double discountedPrice;
	    
}
