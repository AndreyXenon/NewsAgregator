package com.example.test.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.attoparser.dom.Text;
import org.hibernate.annotations.Type;

import java.sql.Blob;
import java.sql.Clob;

@Entity
@Getter
@Setter
@Data
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "img")
    private String img;
    @Column(name = "text")
    private String text;
    public void setTitle(String title){
        this.title = title;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getTitle(){
        return title;
    }
    @Lob
    public String getText(){
        return title;
    }
}
