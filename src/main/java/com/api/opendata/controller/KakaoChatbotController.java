package com.api.opendata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity SearchMovie()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        String response = movieService.RankMovieSearch();;

        return ResponseEntity.ok().headers(headers).body(response);
    }
}

