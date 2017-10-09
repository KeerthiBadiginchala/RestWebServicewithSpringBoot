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
	
	public void addProduct(Product prd){
		
		System.out.println("Product Service: addProduct:"+prd.getProduct_name()+".."+ prd.getSku()+".."+ prd.getCategory()+".."+ prd.getLast_updated());
		try{
		productrepository.insertProduct(prd); 
		}catch(Exception ex){
			//throw 
		}
		
		//Work on it later, inserting into 2 tables at a time
		//productrepository.insertProductPrice(prd);
		
	}
	
	public void updateProduct(Product prd){
		productrepository.updateProduct(prd);
	}
	
	public void deleteProduct(int prd_id){
		productrepository.deleteProduct(prd_id);
	}
	
	
}
