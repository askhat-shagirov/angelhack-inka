package com.angelhack.inka.dto;

/**
 * Created by Mikhail_Voloshin on 6/21/2015.
 */
public class SellerMessageDto {

    private Long id;
    private String name;
    private Long quantity;

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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
