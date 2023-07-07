package com.works.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class BookAuthorJoin {

    @Id
    private Long bid;
    private Integer page_numbers;
    private String title;
    private String name;
    private String bio;

}
