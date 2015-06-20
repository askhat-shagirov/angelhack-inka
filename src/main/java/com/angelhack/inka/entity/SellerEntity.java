package com.angelhack.inka.entity;

import java.util.Collection;
import com.angelhack.inka.common.ItemCategory;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@Entity
public class SellerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    //TODO: add encryption
    private String password;

    private String fullname;
    
    @OneToMany(mappedBy="seller")
    private Collection<StoreEntity> stores;
    
    @ElementCollection(targetClass = ItemCategory.class, fetch = FetchType.EAGER)
    private List<ItemCategory> categories;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seller")
    @Fetch(FetchMode.SUBSELECT)
    private List<DiscountEntity> discounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


	public Collection<StoreEntity> getStores() {
		return stores;
	}

	public void setStores(Collection<StoreEntity> stores) {
		this.stores = stores;
	}
	

    public List<ItemCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ItemCategory> categories) {
        this.categories = categories;
    }

    public List<DiscountEntity> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<DiscountEntity> discounts) {
        this.discounts = discounts;
    }
}
