package com.api.opendata.controller;

import com.api.opendata.Model.MovieModel;
import com.api.opendata.common.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

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

    static String _url = "http://kobis.or.kr";
    static final String _key = "f5eef3421c602c6cb7ea2241047958888";

    @RequestMapping("/api/boxOffice/daily")
    public String SearchDailyBoxOfficeList(@RequestParam String targetDt)
    {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String urlPath = "/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
        String result = "";

        params.add("key", _key);
        params.add("targetDt", targetDt);

        result = Utility.GetHttp(_url, urlPath, params);

        return result;
    }

    @RequestMapping("/api/boxOffice/weekly")
    public String SearchWeeklyBoxOfficeList(@RequestParam String targetDt)
    {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String urlPath = "/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json";
        String result = "";

        params.add("key", _key);
        params.add("targetDt", targetDt);

        result = Utility.GetHttp(_url, urlPath, params);

        return result;
    }

    @RequestMapping("/api/boxOffice/movieList")
    public String SearchMovieList()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String urlPath = "/kobisopenapi/webservice/rest/movie/searchMovieList.json";
        String result = "";

        try{
            params.add("key", _key);

            result = Utility.GetHttp(_url, urlPath, params);

            MovieModel.MovieListResponse test = objectMapper.readValue(result, MovieModel.MovieListResponse.class);

            result = test.getMovieListResult().getTotCnt() + "";
        }
        catch (Exception e){

        }

        return result;
    }

    @RequestMapping("/api/boxOffice/movieInfo")
    public String SearchMovieInfo(@RequestParam String movieCd)
    {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String urlPath = "/kobisopenapi/webservice/rest/movie/searchMovieInfo.json";
        String result = "";

        params.add("key", _key);
        params.add("movieCd", movieCd);

        result = Utility.GetHttp(_url, urlPath, params);

        return result;
    }
}

