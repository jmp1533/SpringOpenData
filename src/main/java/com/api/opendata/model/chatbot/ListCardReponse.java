package com.api.opendata.model.chatbot;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListCardReponse {
    @Getter
    @Setter
    private String version;
    @Getter
    @Setter
    private Template template;

    @Getter
    @Setter
    static public class Template
    {
        private ArrayList<Output> outputs;
    }

    @Getter
    @Setter
    static public class Output
    {
        private ListCard listCard;
    }

    @Getter
    @Setter
    static public class ListCard
    {
        private Header header;
        private ArrayList<Item> items;
        private ArrayList<Button> buttons;
    }

    @Getter
    @Setter
    static public class Header
    {
        private String title;
    }

    @Getter
    @Setter
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
    static public class Link
    {
        private String web;
    }

    @Getter
    @Setter
    static public class Extra
    {
        private String key1;
        private String key2;
    }

    @Getter
    @Setter
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
