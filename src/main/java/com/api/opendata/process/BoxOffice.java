package com.api.opendata.process;

import org.springframework.stereotype.Service;
import com.api.opendata.common.util.Utility;
import com.api.opendata.model.boxoffice.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class BoxOffice {
    static String _url = "http://kobis.or.kr";
    static final String _key = "f5eef3421c602c6cb7ea224104795888";

    public DailyBoxOfficeModel.DailyBoxOfficeResponse SearchDailyBoxOffice(DailyBoxOfficeModel.DailyBoxOfficeRequest dailyRequest) throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String urlPath = "/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
        String result = "";
        DailyBoxOfficeModel.DailyBoxOfficeResponse response = null;

        params.add("key", _key);
        params.add("targetDt", dailyRequest.getTargetDt());
        params.add("wideAreaCd", dailyRequest.getWideAreaCd());

        result = Utility.GetHttp(_url, urlPath, params);

        response = objectMapper.readValue(result, DailyBoxOfficeModel.DailyBoxOfficeResponse.class);

        return response;
    }

    public WeeklyBoxOfficeModel.WeeklyBoxOfficeResponse SearchWeeklyBoxOffice(WeeklyBoxOfficeModel.WeeklyBoxOfficeRequest weeklyRequest) throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String urlPath = "/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json";
        String result = "";
        WeeklyBoxOfficeModel.WeeklyBoxOfficeResponse response = null;

        params.add("key", _key);
        params.add("targetDt", weeklyRequest.getTargetDt());

        result = Utility.GetHttp(_url, urlPath, params);

        response = objectMapper.readValue(result, WeeklyBoxOfficeModel.WeeklyBoxOfficeResponse.class);

        return response;
    }

    public MovieListModel.MovieListResponse SearchMovieList(MovieListModel.MovieListRequest movieListRequest) throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String urlPath = "/kobisopenapi/webservice/rest/movie/searchMovieList.json";
        String result = "";
        MovieListModel.MovieListResponse response= null;

        params.add("key", _key);
        params.add("repNationCd", movieListRequest.getRepNationCd());
        params.add("movieTypeCd", movieListRequest.getMovieTypeCd());

        result = Utility.GetHttp(_url, urlPath, params);

        response = objectMapper.readValue(result, MovieListModel.MovieListResponse.class);

        return response;
    }

    public String SearchMovieInfo(String movieCd) throws JsonProcessingException
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
