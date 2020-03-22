CREATE TABLE PRODUCTS (
  SKU VARCHAR(250) NOT NULL PRIMARY KEY,
  CATAGORIE  VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS BRAND;
  
CREATE TABLE BRAND (
  SKU VARCHAR(250) NOT NULL,
  BRAND VARCHAR(250) NOT NULL,
  CATAGORIE VARCHAR(250) NOT NULL,
  PRICE NUMBER(9,2) NOT NULL,
  COLOUR VARCHAR(250) NOT NULL,
  SIZE NUMBER NOT NULL,
  primary key (SKU,BRAND)
);