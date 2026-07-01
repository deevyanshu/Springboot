package com.deevyanshu.api.Filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.List;
import java.util.function.Predicate;

@Component
public class Validator {

    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    public static final List<String> endpoints = List.of("/register","/generate-token","/validate-token/{token}");

    //if this returns true then the endpoint is not public and need to be authenticated
    public Predicate<ServerHttpRequest> predicate= serverHttpRequest->{
        String requestPath = serverHttpRequest.getURI().getPath();
        return endpoints.stream().noneMatch(uri->pathMatcher.match(uri,requestPath));
    };
}
