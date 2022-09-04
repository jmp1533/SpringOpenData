package com.api.opendata.service;

import com.api.opendata.model.chatbot.ListCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.opendata.common.util.Utility;
import com.api.opendata.model.chatbot.ListCardReponse;
import com.api.opendata.process.Movie;

@Service
public class MovieService {
    @Autowired
    private Movie movie;

    public String RankMovieSearch(ListCardRequest request)
    {
        String response = "";

        try{
            ListCardReponse listCard = movie.RankMovie(request);

            response = Utility.JsonSerialize(listCard);

        }catch (Exception e){
            response = e.getMessage();
        }

        return response;
    }
}
