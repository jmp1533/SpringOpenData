package com.api.opendata.service;

import com.api.opendata.model.boxoffice.DailyBoxOfficeModel;
import com.api.opendata.process.BoxOffice;

public class BoxOfficeService {

    public String RunSearch(String targetDt)
    {
        BoxOffice boxOffice = new BoxOffice();

        DailyBoxOfficeModel.DailyBoxOfficeResponse dailyResponse = null;
        String result = "";

        DailyBoxOfficeModel.DailyBoxOfficeRequest dailyBoxOfficeRequest = new DailyBoxOfficeModel.DailyBoxOfficeRequest();
        dailyBoxOfficeRequest.setTargetDt(targetDt);
        dailyBoxOfficeRequest.setMultiMovieYn("N"); //상업영화
        dailyBoxOfficeRequest.setWideAreaCd("0105001"); //서울
        dailyResponse = boxOffice.SearchDailyBoxOffice(dailyBoxOfficeRequest);

        result = DailyBoxOfficeCard(dailyResponse);


        //boxOffice.SearchWeeklyBoxOffice(targetDt);

        /*MovieListModel.MovieListRequest movieListRequest = new MovieListModel.MovieListRequest();
        movieListRequest.setRepNationCd("22041011"); //한국
        movieListRequest.setMovieTypeCd("220101");
        result = boxOffice.SearchMovieList(movieListRequest);*/

        //boxOffice.SearchMovieInfo("");

        return result;
    }

    public String DailyBoxOfficeCard(DailyBoxOfficeModel.DailyBoxOfficeResponse dailyResponse){
        String dailyCard = "";

        dailyCard += "[" + dailyResponse.getBoxOfficeResult().getBoxofficeType() + " / " + dailyResponse.getBoxOfficeResult().getShowRange() + "]";
        dailyCard += "\r\n";

        /*for (DailyBoxOfficeModel.DailyBoxOffice dailyBoxOffice : dailyResponse.getBoxOfficeResult().getDailyBoxOfficeList()){

            dailyCard += dailyBoxOffice.getRank() + ". ";
            dailyCard += dailyBoxOffice.getMovieNm();

            dailyCard += "\r\n";
        }*/

        dailyCard += "\r\n";

        return dailyCard;
    }
}
