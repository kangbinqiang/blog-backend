package com.boot.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.boot.model.Article;
import com.boot.service.TestService;
import com.boot.service.entity.ArticleDO;
import com.boot.service.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service(version = "1.0.0")
public class TestServiceImpl implements TestService {


    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public String descArticle() {
        List<ArticleDO> all = articleMapper.findAll();
        return JSON.toJSONString(all);
    }

    @Override
    public Article find() {
        Article article = new Article();
        article.setAuthor("kbq");
        article.setName("Dubbo");
        article.setPublishDate(new Date());
        article.setScore(100);
        article.setType("program");
        return article;
    }

    @Override
    public void add() {
        ArticleDO articleDO = new ArticleDO();
        articleDO.setAuthor("kangbinqiang");
        articleDO.setTitle("Dubbo");
        articleDO.setCreatedTime(new Date());
        articleMapper.insert(articleDO);
    }
}
