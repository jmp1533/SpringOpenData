package com.api.opendata.model.boxoffice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

public class DailyBoxOfficeModel {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class DailyBoxOfficeResponse
    {
        public BoxOfficeResult boxOfficeResult;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class BoxOfficeResult
    {
        public String boxofficeType;
        public String showRange;
        public ArrayList<DailyBoxOffice> dailyBoxOfficeList;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class DailyBoxOffice
    {
        public String rnum;
        public String rank;
        public String rankInten;
        public String rankOldAndNew;
        public String movieCd;
        public String movieNm;
        public String openDt;
        public String salesAmt;
        public String salesShare;
        public String salesInten;
        public String salesChange;
        public String salesAcc;
        public String audiCnt;
        public String audiInten;
        public String audiChange;
        public String audiAcc;
        public String scrnCnt;
        public String showCnt;
    }
}
