package pl.edu.vistula.task2_rest_api.product.service;

import org.springframework.stereotype.Service;
import pl.edu.vistula.task2_rest_api.product.api.request.ProductRequest;
import pl.edu.vistula.task2_rest_api.product.api.request.UpdateProductRequest;
import pl.edu.vistula.task2_rest_api.product.api.response.ProductResponse;
import pl.edu.vistula.task2_rest_api.product.domain.Product;
import pl.edu.vistula.task2_rest_api.product.repository.ProductRepository;
import pl.edu.vistula.task2_rest_api.product.support.ProductMapper;
import pl.edu.vistula.task2_rest_api.product.support.exception.ProductExceptionSupplier;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProductResponse create(ProductRequest request) {
        Product saved = repository.save(mapper.toEntity(request));
        return mapper.toResponse(saved);
    }

    public ProductResponse find(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
    }

    public List<ProductResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public ProductResponse update(Long id, UpdateProductRequest request) {
        Product product = repository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));

        Product beforeUpdate = new Product(product.getId(), product.getName());

        product.setName(request.getName());
        repository.save(product);

        return mapper.toResponse(beforeUpdate, request);
    }

    public void delete(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));

        repository.deleteById(product.getId());
    }
}
