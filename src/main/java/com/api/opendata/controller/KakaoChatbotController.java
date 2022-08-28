package com.api.opendata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.api.opendata.service.MovieService;
import java.util.HashMap;

/*
 *
 */

@RestController
@RequestMapping("/api/kakao/chatbot/*")
public class KakaoChatbotController {
    @Autowired
    private MovieService movieService;

    @RequestMapping("/movie/search")
    public HashMap<String, String> SearchMovie()
    {
        HashMap<String, String> result;

        result = movieService.RunSearch();

        return result;
    }
}

