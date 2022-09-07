package com.api.opendata.service;

import com.api.opendata.model.chatbot.ListCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.opendata.common.util.Utility;
import com.api.opendata.model.chatbot.ListCardReponse;
import com.api.opendata.process.Movie;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Service
public class MovieService {
    @Autowired
    private Movie movie;

    public String RunningSearch(ListCardRequest request)
    {
        ListCardReponse listCardRS = new ListCardReponse();
        ListCardReponse.Template Template = new ListCardReponse.Template();
        ArrayList<ListCardReponse.Output> outputList = new ArrayList<>();
        ListCardReponse.Output output = new ListCardReponse.Output();
        ArrayList<ListCardReponse.QuickReplies> quickReplies = new ArrayList<>();
        ListCardReponse.Carousel carousel = new ListCardReponse.Carousel();
        ArrayList<ListCardReponse.ListCard> ListCardItems = new ArrayList<>();

        String type = "";
        String typeKR = "개봉순";
        String response = "";

        try{
            if(false == "영화 보기".equals(request.getUserRequest().getUtterance()) && 1 < request.getUserRequest().getUtterance().split(" ").length){
                typeKR = request.getUserRequest().getUtterance().split(" ")[1];
            }

            type = GetSearchType(typeKR);

            ListCardItems = movie.CurrentSearch(type, typeKR);

            carousel.setType("listCard");
            carousel.setItems(ListCardItems);

            output.setCarousel(carousel);
            outputList.add(output);

            Template.setOutputs(outputList);

            quickReplies.add(GetQuickReplies("처음으로", "영화"));
            quickReplies.add(GetQuickReplies("개봉순", "상영영화 개봉순"));
            quickReplies.add(GetQuickReplies("평점순", "상영영화 평점순"));
            quickReplies.add(GetQuickReplies("좋아요순", "상영영화 좋아요순"));
            quickReplies.add(GetQuickReplies("예매하기", "영화 예매"));
            Template.setQuickReplies(quickReplies);

            listCardRS.setVersion("2.0");
            listCardRS.setTemplate(Template);

            response = Utility.JsonSerialize(listCardRS);

        }catch (Exception e){
            response = e.getMessage();
        }

        return response;
    }

    public ListCardReponse.QuickReplies GetQuickReplies(String label, String message){
        ListCardReponse.QuickReplies quickReplies = new ListCardReponse.QuickReplies();

        quickReplies.setLabel(label);
        quickReplies.setAction("message");
        quickReplies.setMessageText(message);

        return quickReplies;
    }

    public String GetSearchType(String value){
        String type = "open";

        switch (value){
            case "평점순":
                type = "point";
                break;
            case "좋아요순":
                type = "likeCount";
                break;
        }

        return type;
    }
}
