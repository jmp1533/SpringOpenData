package com.api.opendata.process;

import com.api.opendata.common.util.Utility;
import com.api.opendata.model.boxoffice.DailyBoxOfficeModel;
import com.api.opendata.model.boxoffice.MovieListModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class BoxOffice {
    static String _url = "http://kobis.or.kr";
    static final String _key = "f5eef3421c602c6cb7ea224104795888";

    public DailyBoxOfficeModel.DailyBoxOfficeResponse SearchDailyBoxOffice(DailyBoxOfficeModel.DailyBoxOfficeRequest dailyBoxOfficeRequest)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String urlPath = "/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
        String result = "";
        DailyBoxOfficeModel.DailyBoxOfficeResponse response = null;

        params.add("key", _key);
        params.add("targetDt", dailyBoxOfficeRequest.getTargetDt());
        params.add("wideAreaCd", dailyBoxOfficeRequest.getWideAreaCd());

        result = Utility.GetHttp(_url, urlPath, params);

        try{
            response = objectMapper.readValue(result, DailyBoxOfficeModel.DailyBoxOfficeResponse.class);
        }
        catch (Exception e){

        }


        return response;
    }

    public String SearchWeeklyBoxOffice(String targetDt)
    {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String urlPath = "/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json";
        String result = "";

        params.add("key", _key);
        params.add("targetDt", targetDt);

        result = Utility.GetHttp(_url, urlPath, params);

        return result;
    }

    public String SearchMovieList(MovieListModel.MovieListRequest movieListRequest)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String urlPath = "/kobisopenapi/webservice/rest/movie/searchMovieList.json";
        String result = "";

        try{
            params.add("key", _key);
            params.add("repNationCd", movieListRequest.getRepNationCd());
            params.add("movieTypeCd", movieListRequest.getMovieTypeCd());

            result = Utility.GetHttp(_url, urlPath, params);

            MovieListModel.MovieListResponse test = objectMapper.readValue(result, MovieListModel.MovieListResponse.class);

            //result = test.getMovieListResult().getTotCnt() + "";
        }
        catch (Exception e){

        }

        return result;
    }

    public String SearchMovieInfo(String movieCd)
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
