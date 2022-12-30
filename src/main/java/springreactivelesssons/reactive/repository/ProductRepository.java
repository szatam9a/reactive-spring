package springreactivelesssons.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import springreactivelesssons.reactive.model.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
}
