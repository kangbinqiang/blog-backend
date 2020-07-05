package com.boot.model;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Article implements Serializable {

    private String name;

    private String type;

    private String author;

    private Date publishDate;

    private Integer score;
}
