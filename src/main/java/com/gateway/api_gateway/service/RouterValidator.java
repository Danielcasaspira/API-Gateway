package com.gateway.api_gateway.service;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class RouterValidator {

    public static final List<String> openEndpoints = List.of(
            "/auth");

    public Predicate<ServerHttpRequest> isSecured = serverHttpRequest -> {
        return openEndpoints.stream().noneMatch(uri -> serverHttpRequest.getURI().getPath().contains(uri));
    };

}
