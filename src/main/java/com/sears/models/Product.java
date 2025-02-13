package com.sears.models;

public class Product {

    private int id;

    private String name;
    private String description;
    private String price;
    
    
    
	public Product() {
		super();
	}


	public Product(int id, String name, String description, String price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String string) {
		this.price = string;
	}

   
}
