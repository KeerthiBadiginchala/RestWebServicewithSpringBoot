package com.kb.restwswithspringboot.model;

import java.sql.Date;

public class ProdPrice {
	private int product_id;
	private float price;


	ProdPrice(){

	}

	ProdPrice(int product_id, float price){

		this.product_id = product_id;
		this.price = price;

	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
