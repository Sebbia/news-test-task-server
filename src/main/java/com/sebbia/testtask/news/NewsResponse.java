package com.sebbia.testtask.news;

import com.sebbia.testtask.base.response.SuccessResponse;

public class NewsResponse extends SuccessResponse {

    private NewsDtoFull news;

    public NewsResponse(News news) {
        this.news = new NewsDtoFull(news);
    }

    public NewsDtoFull getNews() {
        return news;
    }
}
