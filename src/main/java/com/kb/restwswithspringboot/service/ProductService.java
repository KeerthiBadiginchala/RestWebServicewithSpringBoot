package com.kb.restwswithspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.restwswithspringboot.model.Product;
import com.kb.restwswithspringboot.repository.ProductRepository;


@Service("productservice")
public class ProductService {
	
	@Autowired
	private ProductRepository productrepository;
	
	
	
	public List<Product> getAllProducts(){
		
		return productrepository.getAllProducts(); 
		
	}
	
	public Product getProductByID(int prd_id){
		
		return productrepository.getProductByID(prd_id); 
	}
	
	public Product addProduct(){
		
		return productrepository.addProduct(); 
	}
}
