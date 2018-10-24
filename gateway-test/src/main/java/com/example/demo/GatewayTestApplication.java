package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
@EnableAutoConfiguration
public class GatewayTestApplication {

    public static final String HELLO_FROM_FAKE_ACTUATOR_METRICS_GATEWAY_REQUESTS = "hello from fake /actuator/metrics/gateway.requests";
    @Value("${test.uri:http://httpbin.org:80}")
    String uri;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.host("**.abc.org").and().path("/anything/png")
                        .filters(
                                f -> f.prefixPath("httpbin")
                                        .addResponseHeader("X-TestHeader", "footbar"))
                        .uri(uri))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> testFunRouterFunction() {
        RouterFunction<ServerResponse> route = RouterFunctions.route(
                RequestPredicates.path("/testfun"),
                request -> ServerResponse.ok().body(BodyInserters.fromObject("hello")));
        return route;
    }

    @Bean
    public RouterFunction<ServerResponse> testWhenMetricPathIsNotMeet() {
        RouterFunction<ServerResponse> route = RouterFunctions.route(
                RequestPredicates.path("/actuator/metrics/gateway.requests"),
                request -> ServerResponse.ok().body(BodyInserters.fromObject(HELLO_FROM_FAKE_ACTUATOR_METRICS_GATEWAY_REQUESTS)));
        return route;
    }

    static class Hello {
        String message;

        public Hello() { }

        public Hello(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


    public static void main(String[] args) {
        SpringApplication.run(GatewayTestApplication.class, args);
    }
}
