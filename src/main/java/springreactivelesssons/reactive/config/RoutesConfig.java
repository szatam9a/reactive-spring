package springreactivelesssons.reactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import springreactivelesssons.reactive.handler.ProductHandler;
import springreactivelesssons.reactive.model.Product;
import springreactivelesssons.reactive.service.ProductService;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RoutesConfig {

    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler productHandler) {
        return route()
                .GET("/products", productHandler::getAll)
                .build();
    }

    public RouterFunction<ServerResponse> router(ProductService productService) {
        return route()
                .GET("/products",
                        request -> ok()
                                .contentType(MediaType.TEXT_EVENT_STREAM)
                                .body(productService.getAll(),
                                        Product.class))
                .build();
    }
}
