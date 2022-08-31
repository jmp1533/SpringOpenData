package com.api.opendata.process;


import org.springframework.stereotype.Service;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class Movie {
    static String _movie_url = "https://movie.naver.com";
    static String _schdule_url = "https://movie.naver.com/movie/running/premovie.nhn?order=reserve"; // 네이버영화 개봉 예정작 예매순 1~20위

    public String RankMovie() throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String urlPath = "/movie/running/current.nhn"; // 네이버영화 현재 상영작 예매순위 1~20위
        String result = "";

        Connection conn = Jsoup.connect(_movie_url + urlPath);
        Document document = null;

        try {
            document = conn.get();

            getDataList(document);

        } catch (Exception e) {

        }


        //response = objectMapper.readValue(result, DailyBoxOfficeModel.DailyBoxOfficeResponse.class);

        return result;
    }

    public List<String> getDataList(Document document) {
        List<String> list = new ArrayList<>();
        Element movieList = document.selectFirst(".lst_detail_t1");

        for (Element li : movieList.children()) {

            String imgUrl = li.select(".thumb a img").attr("src"); //이미지URL

            String title = li.select(".lst_dsc .tit a").text(); //타이틀
            String temp = li.select(".lst_dsc .star .tit_t1").next().select(".num").text(); //네이즌 평점

            String  genre = li.select(".lst_dsc dd .info_txt1").next().select(".link_txt a").text();
            /*String genre = "";
            boolean runStatus = true;
            for(Element el : info_txt1.children()){
                if(false == runStatus){
                    genre = el.select(".link_txt a").text().replace(" ", ",");
                    break;
                }

                if("개요".equals(el.text())){
                    runStatus = false;
                }
            }*/

            System.out.println(title + " | " + genre);
            System.out.println("평점 : " + temp + "\t" + "예매율 : " + 0 + "%");
        }



        return list;
    }
}
