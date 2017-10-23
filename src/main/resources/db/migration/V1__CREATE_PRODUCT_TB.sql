CREATE TABLE public.PRODUCT (
    product_id bigserial PRIMARY key,
    product_name varchar(20) NOT NULL,
    sku varchar(20) NOT NULL,
    category varchar(20),
    last_updated TIMESTAMP DEFAULT NULL
);

CREATE TABLE public.PRODUCT_PRICE (
    product_id INT REFERENCES PRODUCT(product_id),
    price NUMERIC(10,3)
);