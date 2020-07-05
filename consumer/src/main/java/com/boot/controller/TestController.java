package com.boot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.boot.model.Article;
import com.boot.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @Reference(version = "1.0.0")
    private TestService testService;

    @GetMapping("hello")
    public String hello() {
        return testService.descArticle();
    }

    @GetMapping("user")
    public Article user() {
        return testService.find();
    }

    @GetMapping("add")
    public void add() {
        testService.add();
    }
}