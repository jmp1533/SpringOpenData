package com.api.opendata.common.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.DecimalFormat;

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

    static public Object GetDecimalFormat(String value, String format){
        DecimalFormat decimalFormat = new DecimalFormat(format);

        return decimalFormat.format(Integer.parseInt(value));
    }
}
