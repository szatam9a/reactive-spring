package springreactivelesssons.reactive.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;

//@Configuration
public class ConnectionConfig {

    @Bean
    ConnectionFactory connectionFactory() {
        return ConnectionFactoryBuilder
                .withUrl("r2dbc:mariadb://localhost:3306")
                .database("reactive")
                .password("locations")
                .username("root")
                .build();
    }
}
