package com.sebbia.testtask.news;

import com.sebbia.testtask.base.entity.PersistEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Category extends PersistEntity {

    @Column
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
    private List<News> news;

    public Category() {

    }

    public String getName() {
        return name;
    }

    public List<News> getNews() {
        return news;
    }
}
