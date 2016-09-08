package com.sebbia.testtask.news;

import com.sebbia.testtask.base.entity.PersistEntity;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table
public class News extends PersistEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;

    @Column
    private String title;

    @Column
    private DateTime date;

    @Column
    private String shortDescription;

    @Column
    private String fullDescription;

    public News() {

    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public DateTime getDate() {
        return date;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }
}
