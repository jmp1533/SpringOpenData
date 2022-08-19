package com.api.opendata.model.boxoffice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

public class WeeklyBoxOfficeModel {

    public class WeeklyBoxOfficeResponse
    {
        public BoxOfficeResult boxOfficeResult;
    }

    public class BoxOfficeResult
    {
        public String boxofficeType;
        public String showRange;
        public String yearWeekTime;
        public ArrayList<WeeklyBoxOffice> weeklyBoxOfficeList;
    }

    public class WeeklyBoxOffice
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
