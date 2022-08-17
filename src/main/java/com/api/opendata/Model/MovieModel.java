package com.api.opendata.Model;

import lombok.*;

import java.util.ArrayList;

public class MovieModel {

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
    static public class MovieListResult
    {
        private int totCnt;
        private String source;
        private ArrayList<MovieList> movieList;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class MovieList
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
    static public class Director
    {
        private String peopleNm;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class Company
    {
        private String companyCd;
        private String companyNm;
    }
}
