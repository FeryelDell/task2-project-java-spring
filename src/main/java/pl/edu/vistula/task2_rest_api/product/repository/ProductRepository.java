package pl.edu.vistula.task2_rest_api.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.vistula.task2_rest_api.product.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
