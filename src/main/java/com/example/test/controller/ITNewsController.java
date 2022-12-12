package com.example.test.controller;

import com.example.test.Model.ITNews;
import com.example.test.Model.News;
import com.example.test.repository.ITNewsRepository;
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
import org.springframework.stereotype.Controller;

@Controller
public class ITNewsController {

    @Autowired
    ITNewsRepository itNewsRepository;

    @GetMapping(value = "/it-news")
    public String getItNews(Model model){
        List<ITNews> newsList = itNewsRepository.findAll();
        model.addAttribute("itnews", newsList);
        return "it-news";
    }

    @GetMapping("/it-news/{id}")
    public String newsDetails(@PathVariable(value = "id") long id, Model model){
        Optional<ITNews> news = itNewsRepository.findById(id);
        //System.out.println(news);
        ArrayList<ITNews> res = new ArrayList<>();
        news.ifPresent(res::add);
        model.addAttribute("itnews", res);
        return "it-news-details";
    }

}
