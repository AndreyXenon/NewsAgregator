package com.example.test.service;

import com.example.test.Model.ITNews;
import com.example.test.Model.News;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface NewsService {
    News addNews(News news);
    News addText(News news);
    boolean isExist(String newsTitle);
    List<News> getAll();
}