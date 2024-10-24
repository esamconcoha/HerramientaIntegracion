package com.react.clients;

import java.util.Base64;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SSAPConsumer {
    @Value("${userExterno}")
    private String username;

    @Value("${passwordExterno}")
    private String password;

    @Value("${ruta.externa}")
    private String urlExterna;

    public HttpHeaders createHeaders() {
        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.US_ASCII));
        String authHeader = "Basic " + new String(encodedAuth);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authHeader);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }


    /*public static HttpHeaders createHeaders() {
        return new HttpHeaders() {
            {
                set("Accept", "/;charset=UTF-8");
                setContentType(MediaType.APPLICATION_JSON);
            }
        };
    }*/

    public <T> ResponseEntity<T> response(
            @Nullable Object body,
            @NotNull @NotBlank String url,
            @NotNull ParameterizedTypeReference<T> responseType,
            @NotNull HttpMethod type
    ) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = createHeaders();
            String ruta = this.urlExterna + url;

            System.out.println("url: " + ruta);
            System.out.println("body: " + body);

            HttpEntity<?> requestBody = new HttpEntity<>(body, headers);

            return restTemplate.exchange(ruta, type, requestBody, responseType);
        } catch (HttpClientErrorException e) {
            System.out.println("Error HTTP: " + e.getResponseBodyAsString());
            return (ResponseEntity<T>) ResponseEntity
                    .status(e.getStatusCode())
                    .body((T) e.getResponseBodyAsString()); // Forzamos un cast controlado
        } catch (RestClientException e) {
            System.out.println("Error en consumir: " + e);
            return (ResponseEntity<T>) ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }



}
