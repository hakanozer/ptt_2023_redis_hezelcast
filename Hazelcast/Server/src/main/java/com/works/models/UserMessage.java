package com.works.models;

import lombok.Data;

@Data
public class UserMessage {

    private Integer uid;
    private String name;
    private String message;
    private long time;
    private long begin;

}
