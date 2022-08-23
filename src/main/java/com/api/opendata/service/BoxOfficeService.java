package com.api.opendata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.opendata.common.util.Utility;
import com.api.opendata.model.boxoffice.*;
import com.api.opendata.process.BoxOffice;
import java.util.HashMap;

@Service
public class BoxOfficeService {
    @Autowired
    private BoxOffice boxOffice;

    public HashMap<String, String> RunSearch(String targetDt)
    {
        DailyBoxOfficeModel.DailyBoxOfficeRequest dailyRequest = new DailyBoxOfficeModel.DailyBoxOfficeRequest();
        WeeklyBoxOfficeModel.WeeklyBoxOfficeRequest weeklyRequest = new WeeklyBoxOfficeModel.WeeklyBoxOfficeRequest();
        MovieListModel.MovieListRequest movieListRequest = new MovieListModel.MovieListRequest();
        DailyBoxOfficeModel.DailyBoxOfficeResponse dailyResponse = null;
        WeeklyBoxOfficeModel.WeeklyBoxOfficeResponse weeklyResponse = null;
        MovieListModel.MovieListResponse movieListResponse = null;

        HashMap<String, String> result = new HashMap<String, String>();

        try{
            //DailyBoxOffice
            dailyRequest.setTargetDt(targetDt);
            dailyRequest.setMultiMovieYn("N"); //상업영화
            //dailyRequest.setWideAreaCd("0105001"); //서울
            dailyResponse = boxOffice.SearchDailyBoxOffice(dailyRequest);

            //result.put("DailyBoxOffice", DailyBoxOfficeCard(dailyResponse));


            //WeeklyBoxOffice
            weeklyRequest.setTargetDt(targetDt);
            weeklyRequest.setWeekGb("0");
            weeklyRequest.setMultiMovieYn("N");
            weeklyResponse = boxOffice.SearchWeeklyBoxOffice(weeklyRequest);

            //result.put("WeeklyBoxOffice", WeeklyBoxOfficeCard(weeklyResponse));


            //MovieList
            movieListRequest.setRepNationCd("22041011"); //한국
            movieListRequest.setMovieTypeCd("220101"); //장편
            movieListResponse = boxOffice.SearchMovieList(movieListRequest);

            result.put("MovieList", MovieListCard(movieListResponse));


            //boxOffice.SearchMovieInfo("");
        }catch (Exception e){
        }

        return result;
    }

    public String DailyBoxOfficeCard(DailyBoxOfficeModel.DailyBoxOfficeResponse dailyResponse){
        StringBuffer dailyCard = new StringBuffer();

        dailyCard.append("[" + dailyResponse.getBoxOfficeResult().getBoxofficeType() + " / " + dailyResponse.getBoxOfficeResult().getShowRange() + "]");

        dailyCard.append(System.lineSeparator());

        for (DailyBoxOfficeModel.DailyBoxOffice dailyBoxOffice : dailyResponse.getBoxOfficeResult().getDailyBoxOfficeList()){
            dailyCard.append(dailyBoxOffice.getRank() + ". ");

            /*if(0 < Integer.parseInt(dailyBoxOffice.getRankInten())){
                dailyCard.append("(" + dailyBoxOffice.getRankInten() + " " + "\\uD83D\\uDD3A) ");
            }*/

            dailyCard.append(dailyBoxOffice.getMovieNm() + System.lineSeparator());
            dailyCard.append("   ● 개봉일 : " + dailyBoxOffice.getOpenDt() + System.lineSeparator());
            dailyCard.append("   ● 누적 관객수 : " + Utility.GetDecimalFormat(dailyBoxOffice.getAudiAcc(),"###,###") + System.lineSeparator());
        }

        dailyCard.append(System.lineSeparator());

        return dailyCard.toString();
    }

    public String WeeklyBoxOfficeCard(WeeklyBoxOfficeModel.WeeklyBoxOfficeResponse weeklyResponse){
        StringBuffer weeklyCard = new StringBuffer();

        //weeklyCard.append(System.lineSeparator());
        weeklyCard.append("[" + weeklyResponse.getBoxOfficeResult().getBoxofficeType() + " / " + weeklyResponse.getBoxOfficeResult().getShowRange() + "]");

        weeklyCard.append(System.lineSeparator());

        return weeklyCard.toString();
    }

    public String MovieListCard(MovieListModel.MovieListResponse movieListResponse){
        StringBuffer movieListCard = new StringBuffer();

        for(MovieListModel.Movie movie : movieListResponse.getMovieListResult().getMovieList()){
            // 대표장르 | 영화명
            movieListCard.append(movie.getRepGenreNm()  + " | " + movie.getMovieNm());

            movieListCard.append(System.lineSeparator());
        }

        return movieListCard.toString();
    }
}
