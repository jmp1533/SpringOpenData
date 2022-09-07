package com.api.opendata.model.chatbot;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListCardReponse {
    private String version;
    private Template template;

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static public class Template
    {
        private ArrayList<Output> outputs;
        private ArrayList<QuickReplies> quickReplies;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static public class Output
    {
        private ListCard listCard;
        private Carousel carousel;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static public class QuickReplies{
        private String messageText;
        private String action;
        private String label;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static public class Carousel{
        private String type;
        private ArrayList<ListCard> items;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static public class ListCard
    {
        private Header header;
        private ArrayList<Item> items;
        private ArrayList<Button> buttons;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static public class Header
    {
        private String title;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static public class Item
    {
        private String title;
        private String description;
        private String imageUrl;
        private Link link;
        private String action;
        private String blockId;
        private Extra extra;
        private String messageText;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static public class Link
    {
        private String web;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static public class Extra
    {
        private String key1;
        private String key2;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static public class Button
    {
        private String label;
        private String action;
        private String webLinkUrl;
        private String messageText;
        private String phoneNumber;
        private String blockId;
        private Extra extra;
    }
}
