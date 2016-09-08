package com.sebbia.testtask.news;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NewsRepository extends PagingAndSortingRepository<News, Long> {

    Page<News> findByCategory(Category category, Pageable pageRequest);

}
