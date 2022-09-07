package com.api.opendata.model.chatbot;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListCardRequest {
    private Action action;
    private UserRequest userRequest;

    @Getter
    @Setter
    static public class UserRequest{
        private String utterance;
    }

    @Getter
    @Setter
    static public class Action
    {
        private String name;
        private Params params;
    }

    @Getter
    @Setter
    static public class Params
    {
        private String order;
        private int number;
    }
}
