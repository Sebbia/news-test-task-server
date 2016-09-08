package com.sebbia.testtask.filters;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Profile("!testing")
public class CorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String clientOrigin = request.getHeader("Origin");
        if (clientOrigin != null && !clientOrigin.isEmpty()) {
            response.setHeader("Access-Control-Allow-Origin", clientOrigin);
            response.setHeader("Access-Control-Allow-Methods", "POST, GET");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type");
            response.setHeader("Access-Control-Allow-Credentials", "true");
        }
        filterChain.doFilter(request, response);
    }

    public void destroy() {}

}