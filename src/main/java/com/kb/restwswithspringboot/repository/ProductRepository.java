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
	
	/*(1) Changed the @Select Queries to fetch Price details along with the Product details
	 *    i.e.,PRODCT_PRICE table data with PRODUCT table
	 *(2) Changed the return type of the DML methods to int and added @SelectKey to return the generated 
	 *	  primary key.   
	 * 
	 */
		
	/*******************************************************************************************************************/
	/*PRODUCT table related SQL Starts*/
	/*******************************************************************************************************************/
	
	
	//@Select("select product_id, product_name, sku, category, last_updated from Product")
	@Select("select prd.product_id, product_name, sku, category, last_updated, price from Product prd, Product_Price price where prd.product_id = price.product_id")
	List<Product> getAllProducts();
	
	
	@Select("select prd.product_id, product_name, sku, category, last_updated, price from Product prd, Product_Price price where prd.product_id = price.product_id and prd.product_id = #{product_id}")
	//@Select("select product_id, product_name, sku, category, last_updated from Product where product_id = #{product_id}")
	Product getProductByID(int product_id);
	
	
	@Insert("INSERT INTO PRODUCT (product_name, sku, category, last_updated) values(#{product_name},"
			+ "#{sku},#{category},#{last_updated})")
   @SelectKey(keyProperty="product_id",
    before=false, resultType=Integer.class, statement = {"SELECT max(product_id) from PRODUCT"})
	int insertProduct(Product prd);
	
	
	@Update("Update PRODUCT set product_name=#{product_name}, sku = #{sku}, category = #{category}, last_updated = #{last_updated} where product_id=#{product_id}")
	int updateProduct(Product prd);
	
	@Delete("Delete from PRODUCT where product_id=#{product_id}")
	int deleteProduct(int product_id);
	
	
	/*******************************************************************************************************************/
	/*PRODUCT_PRICE related SQL starts here*/
	/*******************************************************************************************************************/
	
	
	/*
	 * Commented getAllProductPrices(..) method as proce details are eing fetched as part of getAllProduct(..) method.
	 */
	
	/*@Select("select product_id, price from Product_Price where product_id = #{product_id}")
	List<ProdPrice> getAllProductPrices(int product_id);*/
	
	
	/* (1) Changed the signature of addPriceForTheProduct(ProdPrice) to addPriceForTheProduct(Product) to insert the records into
	 *PRODCT_PRICE table as well along with PRODUCT table, so PRODUCT entity is enough.
	 * (2) Similar method signature changes to other methods i.e., updatePriceForTheProduct(..) and deletePriceForTheProduct(..)
	 */
	@Insert("INSERT INTO PRODUCT_PRICE (product_id, price) values(#{product_id},"
			+ "#{price})")
	int addPriceForTheProduct(Product prdPrice);
	
	
	@Update("Update PRODUCT_PRICE set price = #{price} where product_id=#{product_id}")
	int updatePriceForTheProduct(Product prd);
	
	@Delete("Delete from PRODUCT_PRICE where product_id=#{product_id}")
	int deletePriceForTheProduct(int product_id);
	
	
	/*******************************************************************************************************************/
	/*Products by Category*/
	/*******************************************************************************************************************/
	
	//@Select("select product_id, product_name, sku, category, last_updated, price from Product where category = #{categoryName}")
	@Select("select prd.product_id, product_name, sku, category, last_updated, price from Product prd, Product_Price price where prd.product_id = price.product_id category = #{categoryName}")
	List<Product> getAllProductsByCategory(String categoryName);
	
	
}