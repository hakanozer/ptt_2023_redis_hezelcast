package com.works.redismodels;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@RedisHash("note")
@Data
public class Note {

    @Id
    private String id;

    private String title;
    private String detail;
    private String color;

}
