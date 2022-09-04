package com.api.opendata.controller;

import com.api.opendata.model.chatbot.ListCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import com.api.opendata.service.MovieService;

@RestController
@RequestMapping(value = "/api/kakao/chatbot/*")
@Validated
public class KakaoChatbotController {
    @Autowired
    private MovieService movieService;

    @PostMapping(value = "/movie/rank/search", produces = "application/json; charset=UTF8")
    public ResponseEntity SearchMovie(@RequestBody ListCardRequest request)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        String response = movieService.RankMovieSearch(request);;

        return ResponseEntity.ok().headers(headers).body(response);
    }
}

