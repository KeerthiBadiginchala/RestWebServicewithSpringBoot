SELECT
    table_schema || '.' || table_name
FROM
    information_schema.tables
WHERE
    table_type = 'BASE TABLE'
AND
    table_schema NOT IN ('pg_catalog', 'information_schema');



DROP TABLE product;
CREATE TABLE PRODUCT (
    product_id bigserial PRIMARY key,
    product_name varchar(20) NOT NULL,
    sku varchar(20) NOT NULL,
    category varchar(20),
    last_updated TIMESTAMP DEFAULT NULL
);

DROP TABLE PRODUCT_PRICE;
CREATE TABLE PRODUCT_PRICE (
    product_id INT REFERENCES PRODUCT(product_id),
    price NUMERIC(10,3)
);

INSERT INTO PRODUCT (product_id, product_name, sku, category, last_updated)
VALUES (1, 'Stroller', 'AEX143' , 'Toys', CURRENT_TIMESTAMP);

INSERT INTO PRODUCT_PRICE (product_id, price)
VALUES (1, 199.99);

COMMIT;

SELECT * FROM product;
SELECT * FROM PRODUCT_PRICE;

