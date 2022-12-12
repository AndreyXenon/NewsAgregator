package com.example.test.service;

import com.example.test.Model.ITNews;
import com.example.test.Model.News;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ITNewsService {
    ITNews addNews(ITNews news);
    ITNews addText(ITNews news);
    boolean isExist(String newsTitle);
    List<ITNews> getAll();
}
