package com.api.opendata.model.boxoffice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

public class WeeklyBoxOfficeModel {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class WeeklyBoxOfficeRequest{
        private String targetDt;
        private String weekGb;
        private String itemPerPage;
        private String multiMovieYn;
        private String repNationCd;
        private String wideAreaCd;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class WeeklyBoxOfficeResponse
    {
        private BoxOfficeResult boxOfficeResult;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class BoxOfficeResult
    {
        private String boxofficeType;
        private String showRange;
        private String yearWeekTime;
        private ArrayList<WeeklyBoxOffice> weeklyBoxOfficeList;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class WeeklyBoxOffice
    {
        private String rnum;
        private String rank;
        private String rankInten;
        private String rankOldAndNew;
        private String movieCd;
        private String movieNm;
        private String openDt;
        private String salesAmt;
        private String salesShare;
        private String salesInten;
        private String salesChange;
        private String salesAcc;
        private String audiCnt;
        private String audiInten;
        private String audiChange;
        private String audiAcc;
        private String scrnCnt;
        private String showCnt;
    }
}
