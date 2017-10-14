# RestWebServicewithSpringBoot
Building Restful Web services with Spring Boot using Postgres as DB
 
 Refactored the code to do the below changes:
	  (1) Removed Price*.java files to bind Price realted changes along with Product related updates.
	  (2) Changed the signature of pricerepository methods such as addPriceForTheProduct(ProdPrice) to addPriceForTheProduct(Product) to insert the records into
	 PRODCT_PRICE table as well along with PRODUCT table, so PRODUCT entity is enough.
	  (3) Similar method signature changes to other methods. 
	  (4) upgraded to Java1.8 to check lamda expressions.
    (5) Returning ResponseEntity from controller methods to send the status codes along with the response body
	 
