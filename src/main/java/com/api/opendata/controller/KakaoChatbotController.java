package com.api.opendata.controller;

import com.api.opendata.model.chatbot.ListCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import com.api.opendata.service.MovieService;

@RestController
@RequestMapping(value = "/api/kakaochatbot/*")
@Validated
public class KakaoChatbotController {
    @Autowired
    private MovieService movieService;

    @PostMapping(value = "/movie/current", produces = "application/json; charset=UTF8")
    public ResponseEntity CurrentMovie(@RequestBody ListCardRequest request)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        String response = movieService.CurrentSearch(request);

        return ResponseEntity.ok().headers(headers).body(response);
    }

    @PostMapping(value = "/movie/premiere", produces = "application/json; charset=UTF8")
    public ResponseEntity PremiereMovie(@RequestBody ListCardRequest request)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        String response = movieService.PremiereSearch(request);

        return ResponseEntity.ok().headers(headers).body(response);
    }
}

