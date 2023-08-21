package com.mjc.school.repository.data;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.utils.Util;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSource {
    public static final String PATH_AUTHOR = "authors";
    public static final String PATH_CONTENT = "content";
    public static final String PATH_NEWS = "news";
    public static final int DATA_SOURCE_SIZE = 20;

    private final List<AuthorModel> authorModels;
    private final List<NewsModel> newsModels;


    public DataSource() {
        this.authorModels = initAuthorModels();
        this.newsModels = initNewsModels();
    }

    private List<AuthorModel> initAuthorModels() {
        List<AuthorModel> authors = new ArrayList<>();
        List<String> authorsNames = Util.readResFile(PATH_AUTHOR);
        Long id = 1L;
        for (int i = 0; i < DATA_SOURCE_SIZE; i++) {
            LocalDateTime initDate = Util.getRandomTime();
            authors.add(new AuthorModel(id++
                    ,authorsNames.get(i),
                    initDate,
                    initDate));
        }
        return authors;
    }

    private List<NewsModel> initNewsModels() {
        List<NewsModel> newsList = new ArrayList<>();
        List<String> news = Util.readResFile(PATH_NEWS);
        List<String> content = Util.readResFile(PATH_CONTENT);
        Long id = 1L;
        for (int i = 0; i <DATA_SOURCE_SIZE; i++) {
            LocalDateTime initDate = Util.getRandomTime();
            newsList.add(
                    new NewsModel(id++,
                            news.get(i),
                            content.get(i),
                            initDate,
                            initDate,
                            authorModels.get(i).getId())
            );
        }
        return newsList;
    }
    public List<NewsModel> getAllNews() {
        return newsModels;
    }

    public List<AuthorModel> getAllAuthors() {
        return authorModels;
    }
}