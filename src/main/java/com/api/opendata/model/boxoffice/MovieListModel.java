package com.api.opendata.model.boxoffice;

import lombok.*;

import java.util.ArrayList;

public class MovieListModel {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class MovieListRequest{
        private String curPage;
        private String itemPerPage;
        private String movieNm;
        private String directorNm;
        private String openStartDt;
        private String openEndDt;
        private String prdtStartYear;
        private String prdtEndYear;
        private String repNationCd;
        private String movieTypeCd;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class MovieListResponse
    {
        private MovieListResult movieListResult;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class MovieListResult
    {
        private int totCnt;
        private String source;
        private ArrayList<Movie> movieList;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Movie
    {
        private String movieCd;
        private String movieNm;
        private String movieNmEn;
        private String prdtYear;
        private String openDt;
        private String typeNm;
        private String prdtStatNm;
        private String nationAlt;
        private String genreAlt;
        private String repNationNm;
        private String repGenreNm;
        private ArrayList<Director> directors;
        private ArrayList<Company> companys;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Director
    {
        private String peopleNm;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Company
    {
        private String companyCd;
        private String companyNm;
    }
}
