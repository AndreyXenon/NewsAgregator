package com.example.test.service;

import com.example.test.Model.ITNews;
import com.example.test.Model.News;
import com.example.test.repository.ITNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ITNewsServiceImpl implements ITNewsService {
    @Autowired
    ITNewsRepository itNewsRepository;
    @Override
    public ITNews addNews (ITNews news){
        ITNews savedNews = itNewsRepository.saveAndFlush(news);
        return savedNews;
    }
    @Override
    public ITNews addText (ITNews news){
        ITNews savedText = itNewsRepository.saveAndFlush(news);
        return savedText;
    }
    @Override
    public boolean isExist(String newsTitle){
        List<ITNews> news = itNewsRepository.findAll();
        for (ITNews n: news){
            if (n.getTitle().equals(newsTitle)){
                return true;
            }
        }
        return false;
    }
    @Override
    public List<ITNews> getAll(){
        return itNewsRepository.findAll();
    }
}
