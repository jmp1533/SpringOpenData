package com.api.opendata.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    /*
     * Utility.JsonSerialize(listCard);
     */
    static public String JsonSerialize(Object value)  throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(value);
    }

    /*
     * Utility.JsonDeSerialize(rankMovie, ListCardReponse.class);
     */
    static public <T> T JsonDeSerialize(String value, Class<T> obj)  throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(value, obj);
    }

    static public Object GetDecimalFormat(String value, String format){
        DecimalFormat decimalFormat = new DecimalFormat(format);

        return decimalFormat.format(Integer.parseInt(value));
    }
}
