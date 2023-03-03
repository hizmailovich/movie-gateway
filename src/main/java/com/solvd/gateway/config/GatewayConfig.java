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
                .route("movie_route",
                        route -> route.path("/movie/**")
                                .filters(filter -> filter.stripPrefix(1))
                                .uri("lb://movie"))
                .route("review_route",
                        route -> route.path("/review/**")
                                .filters(filter -> filter.stripPrefix(1))
                                .uri("lb://review"))
                .build();
    }

}
