package com.example.test.job;

import com.example.test.Model.ITNews;
import com.example.test.Model.News;
import com.example.test.service.ITNewsService;
import com.example.test.service.NewsService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class Parser {
    @Autowired
    NewsService newsService;
    @Qualifier("ITNewsServiceImpl")
    @Autowired
    ITNewsService itNewsService;
    @Scheduled(fixedDelay = 10000000)
    public void parseNewNews(){
        String url = "https://cryptonews.net/ru/";

        try {
            Document doc = Jsoup.connect(url).get();
            List<Element> titles = doc.select("body > main > div.container > div.content.row > " +
                    "section.col-xs-12.col-sm > div.row.news-item.start-xs > " +
                    "div.desc.col-xs > a.title");
            for (int i = 0; i < titles.size(); i++){
                String href = titles.get(i).attr("href");
                String tempHref = "https://cryptonews.net" + href;
                Document tempNews = Jsoup.connect(tempHref).get();
                var tempTitle = tempNews.select("body > main > div.container > div.content.row > " +
                        "section.col-xs-12.col-sm > h1.article_title");
                var bodies = tempNews.select("body > main > div.container> div.content.row > " +
                        "section.col-xs-12.col-sm > div.news-item.detail.content_text > p");
                var imgUrl = tempNews.select("body > main > div.container> div.content.row > "+
                        "section.col-xs-12.col-sm > div.news-item.detail.content_text > div.detail-image-wrap");
                News temp = new News();
                String title = tempTitle.text();
                String tempText = bodies.text();
                String image = imgUrl.attr("style");
                String img = image.substring(22, image.length()-1);
                temp.setTitle(title);
                temp.setText(tempText);
                temp.setImg(img);
                newsService.addNews(temp);
            }
            Document doc2 = Jsoup.connect("https://www.it-world.ru/news/").get();
            List<Element> titles2 = doc2.select("div.news__content > h3 > a");
            for (int j = 0; j < titles2.size(); j++) {
                String href2 = titles2.get(j).attr("href");
                String tempHref2 = "https://www.it-world.ru" + href2;
                System.out.println(tempHref2);
                Document tempNews2 = Jsoup.connect(tempHref2).get();
                var tempTitle2 = tempNews2.select("div.page-content > h1");
                var tempContent = tempNews2.select("div.news-detail__content > p");
                var imgUrl2 = tempNews2.select("div.news-detail__picture > figure > a");
                ITNews itNews = new ITNews();
                String title2= tempTitle2.text();
                String content2 = tempContent.text();
                String image2 =  "https://www.it-world.ru" + imgUrl2.attr("href");
                itNews.setTitle(title2);
                itNews.setText(content2);
                itNews.setImg(image2);
                itNewsService.addNews(itNews);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try {
            Document doc2 = Jsoup.connect(url2).get();
            List<Element> titles2 = doc2.select("body > div.page-wrapper.page > div.page-content > " +
                    "div > div.load-list > div.hews-list > div.news__content > h3 > a");
            for (int j = 0; j < titles2.size(); j++){
                String href2 = titles2.get(j).attr("href");
                String tempHref2 = "https://www.it-world.ru" + href2;
                System.out.println(tempHref2);
            /*Document tempNews2 = Jsoup.connect(tempHref2).get();
               var tempTitle = tempNews2.select("body > main > div.container > div.content.row > " +
                       "section.col-xs-12.col-sm > h1.article_title");
               var bodies = tempNews.select("body > main > div.container> div.content.row > " +
                        "section.col-xs-12.col-sm > div.news-item.detail.content_text > p");
               var imgUrl = tempNews.select("body > main > div.container> div.content.row > "+
                        "section.col-xs-12.col-sm > div.news-item.detail.content_text > div.detail-image-wrap");
               News temp = new News();
               String title = tempTitle.text();
               String tempText = bodies.text();
               String image = imgUrl.attr("style");
               String img = image.substring(22, image.length()-1);


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*List<Element> titles2 = doc2.select("body > div.page-wrapper.page > div.page-content > " +
                "div > div.load-list > div.hews-list > div.news__content > h3 > a");
        for (int j = 0; j < titles2.size(); j++){
            String href2 = titles2.get(j).attr("href");
            String tempHref2 = "https://www.it-world.ru" + href2;
            System.out.println(tempHref2);
            Document tempNews2 = Jsoup.connect(tempHref2).get();
               var tempTitle = tempNews2.select("body > main > div.container > div.content.row > " +
                       "section.col-xs-12.col-sm > h1.article_title");
               var bodies = tempNews.select("body > main > div.container> div.content.row > " +
                        "section.col-xs-12.col-sm > div.news-item.detail.content_text > p");
               var imgUrl = tempNews.select("body > main > div.container> div.content.row > "+
                        "section.col-xs-12.col-sm > div.news-item.detail.content_text > div.detail-image-wrap");
               News temp = new News();
               String title = tempTitle.text();
               String tempText = bodies.text();
               String image = imgUrl.attr("style");
               String img = image.substring(22, image.length()-1);*/


    }
}
