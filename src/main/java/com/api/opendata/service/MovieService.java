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

        LinkedHashMap<String, String> types = new LinkedHashMap<>();
        int movieCount = 0;
        String response = "";

        try{
            types.put("open", "개봉순");
            types.put("point", "평점순");
            types.put("likeCount", "좋아요순");

            if("현재 상영영화 더보기".equals(request.getUserRequest().getUtterance())){
                movieCount = 5;

                quickReplies.add(GetQuickReplies("처음으로", "영화"));
                quickReplies.add(GetQuickReplies("예매하기", "영화 예매"));
            }

            for(String type : types.keySet()) {
                ListCardReponse.ListCard listCard = movie.CurrentSearch(type, types.get(type), movieCount);

                ListCardItems.add(listCard);
            }

            carousel.setType("listCard");
            carousel.setItems(ListCardItems);

            output.setCarousel(carousel);
            outputList.add(output);

            Template.setOutputs(outputList);

            if(0 != quickReplies.size()){
                Template.setQuickReplies(quickReplies);
            }

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
}
