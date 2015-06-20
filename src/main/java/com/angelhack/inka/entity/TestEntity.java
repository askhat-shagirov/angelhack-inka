package com.angelhack.inka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Askhat_Shagirov on 20-Jun-15.
 */
@Entity
public class TestEntity {

    @Id
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}