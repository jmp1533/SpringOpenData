package com.api.opendata.service;

import com.api.opendata.common.util.Utility;
import com.api.opendata.model.chatbot.ListCardReponse;
import com.api.opendata.model.chatbot.ListCardRequest;
import com.api.opendata.process.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class MovieSearch implements Function<ListCardRequest, ListCardReponse> {
    @Override
    public ListCardReponse apply(ListCardRequest request)
    {
        ListCardReponse response = new ListCardReponse();

        try{
            response.setVersion(request.getVersion());

        }catch (Exception e){
        }

        return response;
    }
}
