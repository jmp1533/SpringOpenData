package com.api.opendata.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/*
 * 영화박스오피스 DB (일 3000회 제한)
 * 일별 박스오피스
 * 주간/주말 박스오피스
 * 공통코드 조회
 * 영화목록
 * 영화 상세정보
 * 영화사목록
 * 영화사 상세정보
 * 영화인목록
 * 영화인 상세정보
 */
@RestController
public class BoxOfficeController {

    @RequestMapping("/api/boxOffice/daily")
    public List<String> SearchDailyBoxOfficeList()
    {
        return null;
    }

    @RequestMapping("/api/boxOffice/weekly")
    public List<String> SearchWeeklyBoxOfficeList(){
        return null;
    }

    @RequestMapping("/api/boxOffice/movieList")
    public List<String> SearchMovieList(){
        return Arrays.asList("영화보기", "Movie");
    }

    @RequestMapping("/api/boxOffice/movieInfo")
    public List<String> SearchMovieInfo(){
        return null;
    }
}

