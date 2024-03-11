CREATE TABLE products (
    id UUID PRIMARY KEY,
    mark VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    stock_quantity INTEGER NOT NULL,
    category VARCHAR(50) NOT NULL
);