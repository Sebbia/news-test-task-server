package com.sebbia.testtask.news;

import org.joda.time.DateTime;

public class NewsDtoFull {

    private Long id;
    private String title;
    private DateTime date;
    private String shortDescription;
    private String fullDescription;

    public NewsDtoFull(News news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.date = news.getDate();
        this.shortDescription = news.getShortDescription();
        this.fullDescription = news.getFullDescription();
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

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }
}
