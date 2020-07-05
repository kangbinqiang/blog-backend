package com.boot.service.mapper;

import com.boot.service.entity.ArticleDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleMapper extends MongoRepository<ArticleDO, String> {
}
