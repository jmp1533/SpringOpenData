package com.api.opendata.common.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

public class Utility {

    static public String GetHttp(String url, String urlPath, MultiValueMap<String, String> params){

        WebClient client = WebClient.builder()
                .baseUrl(url)
                //.defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        String result = client.get()
                            .uri(uriBuilder  -> uriBuilder
                                    .path(urlPath)
                                    .queryParams(params)
                                    .build())
                            .retrieve()
                            .bodyToMono(String.class)
                            .block();

        return result;
    }
}
