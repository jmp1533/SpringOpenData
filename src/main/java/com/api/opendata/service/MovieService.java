package com.api.opendata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.opendata.model.boxoffice.MovieListModel;
import com.api.opendata.process.Movie;

import java.util.HashMap;

@Service
public class MovieService {
    @Autowired
    private Movie movie;

    public HashMap<String, String> RunSearch()
    {
        //MovieListModel.MovieListRequest movieListRequest = new MovieListModel.MovieListRequest();
        //MovieListModel.MovieListResponse movieListResponse = null;

        HashMap<String, String> result = new HashMap<String, String>();

        try{
            String rankMovie = movie.RankMovie();

            result.put("RankMovie", rankMovie);

        }catch (Exception e){
            result.put("Error", e.getMessage());
        }

        return result;
    }

    public String MovieListCard(MovieListModel.MovieListResponse movieListResponse){
        StringBuffer movieListCard = new StringBuffer();

        for(MovieListModel.Movie movie : movieListResponse.getMovieListResult().getMovieList()){
            // 대표장르 | 영화명
            movieListCard.append(movie.getRepGenreNm()  + " | " + movie.getMovieNm());

            movieListCard.append(System.lineSeparator());
        }

        return movieListCard.toString();
    }
}
