package com.kb.restwswithspringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.restwswithspringboot.model.Product;
import com.kb.restwswithspringboot.repository.ProductRepository;

@Service("productcategoryservice")
public class ProductCategoryService {
	@Autowired
	private ProductRepository productrepository;

	public List<Product> getAllProductsByCategory(String categoryName){
		List<Product> prdList= productrepository.getAllProductsByCategory(categoryName);;
		return  prdList;
    }
}


