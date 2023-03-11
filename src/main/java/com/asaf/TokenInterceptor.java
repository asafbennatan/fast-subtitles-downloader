package com.asaf;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

class TokenInterceptor implements ClientHttpRequestInterceptor {
    private final String token;

    public TokenInterceptor(String token) {
        this.token = token;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        //set token if not null
        if (token != null) {
            request.getHeaders().add("Api-Key", token);
        }
        return execution.execute(request, body);
    }
}
