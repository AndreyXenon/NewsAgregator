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
@Table(name = "itnews")
public class ITNews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;
    private String img;
    @Column(name = "text")
    @Lob
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
