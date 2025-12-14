package pl.edu.vistula.task2_rest_api.product.support;

import org.springframework.stereotype.Component;
import pl.edu.vistula.task2_rest_api.product.api.request.ProductRequest;
import pl.edu.vistula.task2_rest_api.product.api.request.UpdateProductRequest;
import pl.edu.vistula.task2_rest_api.product.api.response.ProductResponse;
import pl.edu.vistula.task2_rest_api.product.domain.Product;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {
        return new Product(null, request.getName());
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }

    public ProductResponse toResponse(Product beforeUpdate, UpdateProductRequest request) {
        return new ProductResponse(beforeUpdate.getId(), beforeUpdate.getName());
    }
}
