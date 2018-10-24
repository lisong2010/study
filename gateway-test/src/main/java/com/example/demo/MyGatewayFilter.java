package com.example.demo;

import java.util.concurrent.TimeUnit;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-09-20
 */
public class MyGatewayFilter implements GatewayFilter{

    int capacity;
    int refillTokens;
    int refillPeriod;
    TimeUnit refillUnit;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRefillTokens() {
        return refillTokens;
    }

    public void setRefillTokens(int refillTokens) {
        this.refillTokens = refillTokens;
    }

    public int getRefillPeriod() {
        return refillPeriod;
    }

    public void setRefillPeriod(int refillPeriod) {
        this.refillPeriod = refillPeriod;
    }

    public TimeUnit getRefillUnit() {
        return refillUnit;
    }

    public void setRefillUnit(TimeUnit refillUnit) {
        this.refillUnit = refillUnit;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange,
            GatewayFilterChain gatewayFilterChain) {
        return gatewayFilterChain.filter(serverWebExchange);
    }
}
