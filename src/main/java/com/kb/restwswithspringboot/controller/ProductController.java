package com.kb.restwswithspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kb.restwswithspringboot.model.*;

import java.lang.invoke.MethodType;
import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import com.kb.restwswithspringboot.service.ProductPriceService;
import com.kb.restwswithspringboot.service.ProductService;

@RestController
@RequestMapping("/restwswithspringboot")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	
	//Check with XML format later
	@RequestMapping(value = "/products", method= RequestMethod.GET, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Product> getAllProducts(){
		List<Product> prdList = new ArrayList<Product>();
		prdList = productservice.getAllProducts();
		return prdList;
	}
	
	@RequestMapping(value = "/products/{id}", method= RequestMethod.GET)
	public Product getProductByID(@PathVariable("id") int product_id){
		Product prdoduct = productservice.getProductByID(product_id);
		//return Response.status((StatusType) Response.ok()).entity(prdoduct).build();
		return prdoduct;
	}
	
	@RequestMapping(value = "/products", method= RequestMethod.POST)
	public void addProduct(@RequestBody Product prd){
		System.out.println("addProduct: "+prd.toString());
		//Product prdoduct = productservice.addProduct(prd);
		productservice.addProduct(prd);
		//return Response.status((StatusType) Response.ok()).entity(prdoduct).build();
		//return prdoduct;
	}
	
	@RequestMapping(value = "/products/{id}", method= RequestMethod.PUT)
	public void updateProduct(@PathVariable("id") int product_id, @RequestBody Product prd){
		prd.setProduct_id(product_id);
		System.out.println("updateProduct: "+prd.toString());
		productservice.updateProduct(prd);
	}
	
	@RequestMapping(value = "/products/{id}", method= RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int product_id){
		System.out.println("deleteProduct: "+product_id);
		productservice.deleteProduct(product_id);
	}
	
	/*@RequestMapping(value = "/products/{prd_id}/prices")
	public PriceController getPriceDetails(){
		return new PriceController();
	}*/

}
