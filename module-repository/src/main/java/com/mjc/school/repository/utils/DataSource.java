package com.mjc.school.repository.utils;

import com.mjc.school.repository.model.Author;
import com.mjc.school.repository.model.NewsModel;
import lombok.Getter;

import java.io.IOException;
import java.util.List;

public class DataSource {
    public List<NewsModel> getNewsModelList() {
        return newsModelList;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    @Getter
    private final List<NewsModel> newsModelList;

    @Getter
    private final List<Author> authorList;

    public DataSource() throws IOException {
        DataInitializer dataInitializer = new DataInitializer();
        authorList = dataInitializer.initializeAuthorList();
        newsModelList = dataInitializer.initializeNewsList(authorList);
    }
}
