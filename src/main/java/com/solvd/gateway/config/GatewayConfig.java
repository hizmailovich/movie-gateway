package com.solvd.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("author_route",
                        route -> route.path("/author/**")
                                .filters(filter -> filter.stripPrefix(1))
                                .uri("lb://author"))
                .route("book_route",
                        route -> route.path("/book/**")
                                .filters(filter -> filter.stripPrefix(1))
                                .uri("lb://book"))
                .build();
    }

}
