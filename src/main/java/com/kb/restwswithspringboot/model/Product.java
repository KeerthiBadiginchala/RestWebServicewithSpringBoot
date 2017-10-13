package com.kb.restwswithspringboot.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlTransient;

public class Product {
	
	private int product_id;
	private String product_name;
	private String sku;
	private String category;
	private Date last_updated;
	private float price; 
	
	Product(){
		
	}
	
	Product(int product_id, String product_name, String sku, String category, Date last_updated){
		
		this.product_id = product_id;
		this.product_name = product_name;
		this.sku = sku;
		this.category = category;
		this.last_updated = last_updated;
		
	}
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}

	@XmlTransient
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name="
				+ product_name + ", sku=" + sku + ", category=" + category
				+ ", last_updated=" + last_updated + "]";
	}
	

}
