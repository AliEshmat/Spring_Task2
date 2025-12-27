package com.vistula.task2.product.support.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Product with id: " + id + " not found");
    }
}
