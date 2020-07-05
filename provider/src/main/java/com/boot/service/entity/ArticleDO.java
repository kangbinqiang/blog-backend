package com.boot.service.entity;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "article")
@Data
public class ArticleDO {

    private String title;

    private String author;

    private Date createdTime;
}
