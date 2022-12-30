package springreactivelesssons.reactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import springreactivelesssons.reactive.model.Product;
import springreactivelesssons.reactive.repository.ProductRepository;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Flux<Product> getAll() {
        return productRepository.findAll()
                .delayElements(Duration.ofSeconds(5));

    }
}
