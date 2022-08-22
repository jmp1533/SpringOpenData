package com.api.opendata.service;

import com.api.opendata.common.util.Utility;
import com.api.opendata.model.boxoffice.DailyBoxOfficeModel;
import com.api.opendata.model.boxoffice.WeeklyBoxOfficeModel;
import com.api.opendata.process.BoxOffice;

public class BoxOfficeService {

    public String RunSearch(String targetDt)
    {
        BoxOffice boxOffice = new BoxOffice();

        DailyBoxOfficeModel.DailyBoxOfficeResponse dailyResponse = null;
        WeeklyBoxOfficeModel.WeeklyBoxOfficeResponse weeklyResponse = null;
        StringBuffer result = new StringBuffer();

        //DailyBoxOffice
        DailyBoxOfficeModel.DailyBoxOfficeRequest dailyBoxOfficeRequest = new DailyBoxOfficeModel.DailyBoxOfficeRequest();
        dailyBoxOfficeRequest.setTargetDt(targetDt);
        dailyBoxOfficeRequest.setMultiMovieYn("N"); //상업영화
        //dailyBoxOfficeRequest.setWideAreaCd("0105001"); //서울
        dailyResponse = boxOffice.SearchDailyBoxOffice(dailyBoxOfficeRequest);

        result.append(DailyBoxOfficeCard(dailyResponse));


        //WeeklyBoxOffice
        WeeklyBoxOfficeModel.WeeklyBoxOfficeRequest weeklyRequest = new WeeklyBoxOfficeModel.WeeklyBoxOfficeRequest();
        weeklyRequest.setTargetDt(targetDt);
        weeklyResponse = boxOffice.SearchWeeklyBoxOffice(weeklyRequest);

        result.append(WeeklyBoxOfficeCard(weeklyResponse));



        /*MovieListModel.MovieListRequest movieListRequest = new MovieListModel.MovieListRequest();
        movieListRequest.setRepNationCd("22041011"); //한국
        movieListRequest.setMovieTypeCd("220101");
        result = boxOffice.SearchMovieList(movieListRequest);*/

        //boxOffice.SearchMovieInfo("");

        return result.toString();
    }

    public StringBuffer DailyBoxOfficeCard(DailyBoxOfficeModel.DailyBoxOfficeResponse dailyResponse){
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

        return dailyCard;
    }

    public StringBuffer WeeklyBoxOfficeCard(WeeklyBoxOfficeModel.WeeklyBoxOfficeResponse weeklyResponse){
        StringBuffer weeklyCard = new StringBuffer();

        //weeklyCard.append(System.lineSeparator());



        return weeklyCard;
    }
}
