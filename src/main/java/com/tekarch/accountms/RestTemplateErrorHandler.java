package com.tekarch.accountms;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class RestTemplateErrorHandler  extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        // Custom error handling logic
        System.out.println("HTTP Status Code: " + response.getStatusCode());
    }
}
