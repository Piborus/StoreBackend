CREATE TABLE orders (
    id UUID PRIMARY KEY,
    client_id UUID,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE order_products (
    order_id UUID,
    product_id UUID,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);
