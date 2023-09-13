package com.wellsfargo.training.ims.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

/*
 * Model class for managing Product Objects - CRUD
 */

/* The @Entity annotation specifies that the class is an entity and is mapped to a database table.*/
@Entity
public class Product {
	
	/* @Id annotation specifies the primary key of an entity
	 * @GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	 * If only strategy = GenerationType.IDENTITY, it means auto numbering and Id starts from 1.
	 * Giving a seq gen helps to custom change Id range  */
	
	
	@SequenceGenerator(name="product_seq",initialValue=1000,allocationSize=1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator="product_seq")
	private long pid;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String brand;
	
	@Column(nullable=false)
	private String madein;
	
	@Column(nullable=false)
	private float price;
	
	
	//Default constructor - generate constructor from super class
	public Product() {
		super();
	}

	//Parameterized constructor - generate constructor using fields
	public Product(long pid, String name, String brand, String madein, float price) {
		super();
		this.pid = pid;
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.price = price;
	}

	//Generate getters and setters for all fields
	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMadein() {
		return madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
	
	

}
