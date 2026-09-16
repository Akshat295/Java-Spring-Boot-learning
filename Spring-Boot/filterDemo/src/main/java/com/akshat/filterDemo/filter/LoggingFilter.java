package com.akshat.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        long startTime = System.currentTimeMillis();

        String requestId = UUID.randomUUID().toString();

        httpResponse.setHeader("X-Request-Id", requestId);

        System.out.println("Incoming request: " + httpRequest.getRequestURI() + " " + httpRequest.getMethod());

        try{
            chain.doFilter(request, response);
        } finally {
            long endTime = System.currentTimeMillis();

            long executionTime = endTime - startTime;

            System.out.println("Response code: " + httpResponse.getStatus());

            System.out.println("API response time: " + executionTime);
        }


    }
}
