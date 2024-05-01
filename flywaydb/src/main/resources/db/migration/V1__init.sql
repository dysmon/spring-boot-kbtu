CREATE TABLE IF NOT EXISTS products (
    id UUID PRIMARY KEY,
    product_name  VARCHAR(255) NOT NULL,
    stock NUMERIC NOT NULL default 0,
    manufacturer VARCHAR(255) NOT NULL
);