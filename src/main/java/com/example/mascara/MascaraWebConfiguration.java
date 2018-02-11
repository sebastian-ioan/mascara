package com.example.mascara;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.DelegatingWebFluxConfiguration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MascaraWebConfiguration extends DelegatingWebFluxConfiguration {


    @Bean
    RouterFunction router(MascaraHandler handler) {
        return route(GET("/hello").and(contentType(MediaType.APPLICATION_JSON)), handler::hello);
    }

}
