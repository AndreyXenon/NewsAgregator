package com.example.test.controller;

import com.example.test.Model.News;
import com.example.test.repository.NewsRepository;
import com.example.test.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Controller
public class NewsController {
    @Autowired
    NewsRepository newsRepository;

    @GetMapping("/{id}")
    public String newsDetails(@PathVariable(value = "id") long id, Model model){
        Optional<News> news = newsRepository.findById(id);
        System.out.println(news);
        ArrayList<News> res = new ArrayList<>();
        news.ifPresent(res::add);
        model.addAttribute("news", res);
        return "news-details";
    }

    @GetMapping(value = "/")
    public String getNews(Model model){
        List<News> newsList = newsRepository.findAll();
        model.addAttribute("news", newsList);
        return "index";
    }
}
