package com.api.opendata.model.boxoffice;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public class WeeklyBoxOfficeModel {

    @Getter
    @Setter
    static public class WeeklyBoxOfficeRequest{
        private String targetDt;
        private String weekGb;
        private String itemPerPage;
        private String multiMovieYn;
        private String repNationCd;
        private String wideAreaCd;
    }

    @Getter
    @Setter
    static public class WeeklyBoxOfficeResponse
    {
        private BoxOfficeResult boxOfficeResult;
    }

    @Getter
    @Setter
    static public class BoxOfficeResult
    {
        private String boxofficeType;
        private String showRange;
        private String yearWeekTime;
        private ArrayList<WeeklyBoxOffice> weeklyBoxOfficeList;
    }

    @Getter
    @Setter
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
