package com.kb.restwswithspringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kb.restwswithspringboot.model.Product;
import com.kb.restwswithspringboot.repository.ProductRepository;


@Service("productservice")
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository productrepository;
	
	
	
	public List<Product> getAllProducts(){
		
		//Lamda Expression Usage Purpose java1.8
		List<Product> prdList = productrepository.getAllProducts(); 
		prdList.forEach(prd -> System.out.println(prd));
		System.out.println("check Lamda Expression:"+prdList.stream().filter(prd -> prd.getProduct_name().startsWith("A")).count());
		//Lamda Chnages done
		
		return productrepository.getAllProducts();
		
	}
	
	//Exception Handling Scope, Integer check
	public List<Product> getMultipleProducts(String ids){
		List<Product> prdList = new ArrayList<Product>();
		
		String[] args = ids.split(",");
		for(int i=0;i<args.length;i++){
			Product prd = productrepository.getProductByID(Integer.parseInt(args[i]));
			prdList.add(prd);
		}
		
		return prdList; 
	}
	
	public Product getProductByID(int prd_id){
		System.out.println("getProductByID, prd_id:"+prd_id);
		return productrepository.getProductByID(prd_id); 
	}
	
	/*
	 * Changed the method to insert the product details including price into 2 tables, Product and Product_Price
	 * at a time and return the inserted Object.
	 * void addPriceForTheProduct(ProdPrice) signature is going to change as Product addPriceForTheProduct(Product)
	 */
	public Product addProduct(Product prd){
		
		System.out.println("Product Service: addProduct:"+prd.getProduct_name()+".."+ prd.getSku()+".."+ prd.getCategory()+".."+ prd.getLast_updated());
		int status = productrepository.insertProduct(prd);
		System.out.println("insert status:"+status);
		Product productObj= null;
		try{
			if(status == 1){ 
				System.out.println("generated Product ID:"+prd.getProduct_id()+"prd Obj:"+prd.toString());
				status = productrepository.addPriceForTheProduct(prd);
				System.out.println("inserted price table status:"+status);
				if(status == 1){
					productObj = getProductByID(prd.getProduct_id());
				}
			}
		
		}catch(Exception ex){
			//throw 
		}
		return productObj;
		
	}
	
	
	/*
	 * Changed the method to update the product details including price into 2 tables, Product and Product_Price
	 * at a time and return the updated Object.
	 * void updateProduct(ProdPrice) signature is going to change as Product updateProduct(Product)
	 */
	public Product updateProduct(Product prd){
		int status = productrepository.updatePriceForTheProduct(prd);
		Product productObj= null;
		if(status == 1){ 
			status = productrepository.updateProduct(prd);
			if(status == 1){
				productObj = getProductByID(prd.getProduct_id());
			}
		}
		return productObj;
	}
	
	
	/*
	 * Changed the method to delete the product details including price into 2 tables, Product and Product_Price
	 * at a time and return the deleted Key.
	 * void deleteProduct(ProdPrice) signature is going to change as int deleteProduct(Product)
	 */
	public int deleteProduct(int prd_id){
		int status = productrepository.deletePriceForTheProduct(prd_id);
		if(status == 1){ 
			status = productrepository.deleteProduct(prd_id);
		}
		return status;
	}
	
	
}
