package com.api.opendata.model.boxoffice;

import lombok.*;
import java.util.ArrayList;

public class DailyBoxOfficeModel {

    @Getter
    @Setter
    static public class DailyBoxOfficeRequest{
        private String targetDt;
        private String itemPerPage;
        private String multiMovieYn;
        private String repNationCd;
        private String wideAreaCd;
    }

    @Getter
    @Setter
    static public class DailyBoxOfficeResponse
    {
        private BoxOfficeResult boxOfficeResult;
    }

    @Getter
    @Setter
    static public class BoxOfficeResult
    {
        private String boxofficeType;
        private String showRange;
        private ArrayList<DailyBoxOffice> dailyBoxOfficeList;
    }

    @Getter
    @Setter
    static public class DailyBoxOffice
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
