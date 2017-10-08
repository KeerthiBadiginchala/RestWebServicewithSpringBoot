package com.kb.restwswithspringboot.repository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kb.restwswithspringboot.model.*;

import java.util.List;

@Mapper
public interface ProductRepository {



	/*	@Insert("insert into users(name,email) values(#{name},#{email})")
	    @SelectKey(statement="call identity()", keyProperty="id",
	    before=false, resultType=Integer.class)
	    void insertUser(User user);


	    @Select("select id, name, email from users WHERE id=#{id}")
	    User findUserById(Integer id);*/


	//@Select("select product_id, product_name, sku, category, last_updated from Product")
	@Select("select prd.product_id, product_name, sku, category, last_updated, price from Product prd, Product_Price price where prd.product_id = price.product_id")
	List<Product> getAllProducts();
	
	
	@Select("select prd.product_id, product_name, sku, category, last_updated, price from Product prd, Product_Price price where prd.product_id = price.product_id and prd.product_id = #{product_id}")
	Product getProductByID(int product_id);
	
	@Insert
	Product addProduct();

}
