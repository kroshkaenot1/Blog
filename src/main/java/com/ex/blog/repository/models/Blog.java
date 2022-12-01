package com.ex.blog.repository.models;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Length(max = 100)
    String title;
    private String author,content;
    private String dateOfPublishing;

    public Blog(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.dateOfPublishing = String.valueOf(LocalDate.now());
    }
    public Blog(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateOfPublishing() {
        return dateOfPublishing;
    }

    public void setDateOfPublishing(String dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }
}
