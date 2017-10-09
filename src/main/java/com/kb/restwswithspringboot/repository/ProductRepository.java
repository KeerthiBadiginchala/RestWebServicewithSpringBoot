package com.kb.restwswithspringboot.repository;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.kb.restwswithspringboot.model.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface ProductRepository {

	
	/*PRODUCT table related SQL Starts*/

	@Select("select product_id, product_name, sku, category, last_updated from Product")
	//@Select("select prd.product_id, product_name, sku, category, last_updated, price from Product prd, Product_Price price where prd.product_id = price.product_id")
	List<Product> getAllProducts();
	
	
	//@Select("select prd.product_id, product_name, sku, category, last_updated, price from Product prd, Product_Price price where prd.product_id = price.product_id and prd.product_id = #{product_id}")
	@Select("select product_id, product_name, sku, category, last_updated from Product where product_id = #{product_id}")
	Product getProductByID(int product_id);
	
	
	@Insert("INSERT INTO PRODUCT (product_name, sku, category, last_updated) values(#{product_name},"
			+ "#{sku},#{category},#{last_updated})")
   // @SelectKey(statement="call identity()", keyProperty="product_id",
   // before=false, resultType=Integer.class)
	void insertProduct(Product prd);
	
	
	@Update("Update PRODUCT set product_name=#{product_name}, sku = #{sku}, category = #{category}, last_updated = #{last_updated} where product_id=#{product_id}")
	void updateProduct(Product prd);
	
	@Delete("Delete from PRODUCT where product_id=#{product_id}")
	void deleteProduct(int product_id);
	
	
	/*PRODUCT_PRICE related SQL starts here*/
	@Select("select product_id, price from Product_Price where product_id = #{product_id}")
	List<ProdPrice> getAllProductPrices(int product_id);
	
	@Insert("INSERT INTO PRODUCT_PRICE (product_id, price) values(#{product_id},"
			+ "#{price})")
	void addPriceForTheProduct(ProdPrice prdPrice);
	
	
	@Update("Update PRODUCT_PRICE set price = #{price} where product_id=#{product_id}")
	void updatePriceForTheProduct(ProdPrice prd);
	
	@Delete("Delete from PRODUCT_PRICE where product_id=#{product_id}")
	void deletePriceForTheProduct(int product_id);
	
	/*Products by Category*/
	@Select("select product_id, product_name, sku, category, last_updated from Product where category = #{categoryName}")
	List<Product> getAllProductsByCategory(String categoryName);
}
