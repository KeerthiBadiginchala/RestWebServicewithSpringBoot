package com.kb.restwswithspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/products", method= RequestMethod.GET)
	@Consumes
	public Product addProduct(){
		Product prdoduct = productservice.addProduct();
		//return Response.status((StatusType) Response.ok()).entity(prdoduct).build();
		return prdoduct;
	}

}
