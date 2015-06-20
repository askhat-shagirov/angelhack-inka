package com.angelhack.inka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TagsEntity {

	 @Id @GeneratedValue
	    private Long id;
	    private String name;
}
