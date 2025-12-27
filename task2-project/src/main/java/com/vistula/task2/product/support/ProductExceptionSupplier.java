package com.vistula.task2.product.support;

import com.vistula.task2.product.support.exception.ProductNotFoundException;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class ProductExceptionSupplier {

    public static Supplier<ProductNotFoundException> productNotFound(Long id) {
        return () -> new ProductNotFoundException(id);
    }
}
