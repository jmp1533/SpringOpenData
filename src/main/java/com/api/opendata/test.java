package com.api.opendata;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class test {
    public class Rootobject
    {
        public Movielistresult movieListResult;
    }

    public class Movielistresult
    {
        public int totCnt;
        public String source;
        public ArrayList<Movielist> movieList;
    }

    public class Movielist
    {
        public String movieCd;
        public String movieNm;
        public String movieNmEn;
        public String prdtYear;
        public String openDt;
        public String typeNm;
        public String prdtStatNm;
        public String nationAlt;
        public String genreAlt;
        public String repNationNm;
        public String repGenreNm;
        public Director[] directors;
        public Company[] companys;
    }

    public class Director
    {
        public String peopleNm;
    }

    public class Company
    {
        public String companyCd;
        public String companyNm;
    }
}
