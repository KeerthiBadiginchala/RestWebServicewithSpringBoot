package com.kb.restwswithspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.kb.restwswithspringboot.service.ProductCategoryService;
import com.kb.restwswithspringboot.service.ProductService;

@RestController
@RequestMapping("/restwswithspringboot")
public class ProductController {

	@Autowired
	private ProductService productservice;

	@Autowired
	private ProductCategoryService productcatservice;


	//Check with XML format later
	@RequestMapping(value = "/products", method= RequestMethod.GET, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> prdList = new ArrayList<Product>();
		prdList = productservice.getAllProducts();
		return new ResponseEntity<List<Product>>(prdList,HttpStatus.FOUND);
	}

	@RequestMapping(value = "/products/{id}", method= RequestMethod.GET)
	public ResponseEntity<Product> getProductByID(@PathVariable("id") int product_id){
		Product product = productservice.getProductByID(product_id);
		return new ResponseEntity<Product>(product,HttpStatus.FOUND);
	}

	@RequestMapping(value = "/multiproducts/{ids}")
	public ResponseEntity<List<Product>> getMultipleProducts(@PathVariable("ids") String prd_Ids){
		List<Product> prdList = new ArrayList<Product>();
		prdList = productservice.getMultipleProducts(prd_Ids);
		return new ResponseEntity<List<Product>>(prdList,HttpStatus.FOUND);
	}
	
	/* ResponseEntity<Product> represents the whole HTTP response object to send the response the way you want to send
	 * i.e., Status, Headers and Response body.
	 */
	@RequestMapping(value = "/products", method= RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody Product prd){
		System.out.println("addProduct: "+prd.toString());
		Product product = productservice.addProduct(prd);
		
		//return Response.status((StatusType) Response.ok()).entity(prdoduct).build();
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/products/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@PathVariable("id") int product_id, @RequestBody Product prd){
		prd.setProduct_id(product_id);
		System.out.println("updateProduct: "+prd.toString());
		Product product = productservice.updateProduct(prd);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") int product_id){
		System.out.println("deleteProduct: "+product_id);
		productservice.deleteProduct(product_id);
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/categories/{categoryName}", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProductsByCategory(@PathVariable("categoryName") String categoryName){
		System.out.println("getAllProductsByCategory: "+categoryName);
		List<Product> prdListByCategory= productcatservice.getAllProductsByCategory(categoryName);
		return new ResponseEntity<List<Product>>(prdListByCategory,HttpStatus.FOUND);
	}

}
