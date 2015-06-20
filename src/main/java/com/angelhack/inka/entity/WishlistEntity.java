package com.angelhack.inka.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mikhail_Voloshin on 6/20/2015.
 */
@Entity
public class WishlistEntity {

    @Id
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToOne
    private UserEntity user;

    @OneToMany(fetch = FetchType.EAGER)
    private List<ItemEntity> items;

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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }
}
