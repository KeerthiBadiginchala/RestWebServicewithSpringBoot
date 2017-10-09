package com.kb.restwswithspringboot.service;

import java.util.ArrayList;
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
	
	//Exception Handling Scope, Integer check
	public List<Product> getMultipleProducts(String ids){
		List<Product> prdList = new ArrayList<Product>();
		
		String[] args = ids.split(",");
		for(int i=0;i<args.length;i++){
			System.out.println("args["+i+"]"+args[i]);
			System.out.println("Integer Conversion"+Integer.parseInt(args[i]));
			Product prd = productrepository.getProductByID(Integer.parseInt(args[i]));
			prdList.add(prd);
		}
		
		return prdList; 
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
