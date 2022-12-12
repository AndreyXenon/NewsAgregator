package com.example.test.service;

import com.example.test.Model.ITNews;
import com.example.test.Model.News;
import com.example.test.repository.ITNewsRepository;
import com.example.test.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository repository;
    @Override
    public News addNews (News news){
        News savedNews = repository.saveAndFlush(news);
        return savedNews;
    }
    @Override
    public News addText (News news){
        News savedText = repository.saveAndFlush(news);
        return savedText;
    }
    @Override
    public boolean isExist(String newsTitle){
        List<News> news = repository.findAll();
        for (News n: news){
            if (n.getTitle().equals(newsTitle)){
                return true;
            }
        }
        return false;
    }
    @Override
    public List<News> getAll(){
        return repository.findAll();
    }

}
