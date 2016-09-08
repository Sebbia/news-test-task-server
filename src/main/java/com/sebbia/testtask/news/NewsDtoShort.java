package com.sebbia.testtask.news;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class NewsDtoShort {

    private Long id;
    private String title;
    private DateTime date;
    private String shortDescription;

    public NewsDtoShort(News news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.date = news.getDate();
        this.shortDescription = news.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

}
