package com.api.opendata.process;

import com.api.opendata.common.util.Utility;
import com.api.opendata.dao.BoxOfficeDao;
import com.api.opendata.model.boxoffice.DailyBoxOfficeModel;
import com.api.opendata.model.boxoffice.MovieListModel;
import com.api.opendata.model.boxoffice.MovieVO;
import com.api.opendata.model.boxoffice.WeeklyBoxOfficeModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Service
public class Movie {
    static String _movie_url = "https://movie.naver.com";
    static String _schdule_url = "https://movie.naver.com/movie/running/premovie.nhn?order=reserve"; // 네이버영화 개봉 예정작 예매순 1~20위

    public String RankMovie() throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String urlPath = "/movie/running/current.nhn"; // 네이버영화 현재 상영작 예매순위 1~20위

        String result = "";
        result = Utility.GetHttp(_movie_url, urlPath, null);


        //response = objectMapper.readValue(result, DailyBoxOfficeModel.DailyBoxOfficeResponse.class);

        return result;
    }
}
