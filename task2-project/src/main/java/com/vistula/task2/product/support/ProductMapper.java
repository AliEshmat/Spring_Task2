package com.vistula.task2.product.support;

import com.vistula.task2.product.api.request.ProductRequest;
import com.vistula.task2.product.api.request.UpdateProductRequest;
import com.vistula.task2.product.api.response.ProductResponse;
import com.vistula.task2.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    // Convert ProductRequest to Product entity
    public Product toProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        return product;
    }

    // Convert Product entity to ProductResponse
    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName()
        );
    }

    // Update existing Product with data from UpdateProductRequest
    public void toProduct(UpdateProductRequest updateProductRequest, Product product) {
        product.setName(updateProductRequest.getName());
    }
}
