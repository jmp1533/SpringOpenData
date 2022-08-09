package com.api.opendata.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController {

    @RequestMapping("/api/movie")
    public List<String> MovieHome(){
        return Arrays.asList("안녕하세요", "Hello");
    }
}
