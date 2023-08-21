package com.mjc.school.repository.aspect;

import com.mjc.school.repository.data.DataSource;
import com.mjc.school.repository.model.NewsModel;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
@Aspect
@Component
public class RepoAspect { private final DataSource dataSource;

    public RepoAspect(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Before("@annotation(com.mjc.school.repository.action.OnDelete) && args(id)")
    public void CascadeOnDelete(Long id){
        List<NewsModel> modelList = dataSource.getAllNews();
        List<NewsModel> removeList = modelList.stream()
                .filter(e -> Objects.equals(e.getAuthorId(),id)).toList();
        modelList.removeAll(removeList);
    }

    @Before("@annotation(com.mjc.school.repository.action.SetNullForeignKey) && args(id)")
    public void setNullForeignKeyOnDelete(Long id){
        List<NewsModel> modelList = dataSource.getAllNews();
        for(NewsModel news : modelList){
            if(news.getAuthorId().equals(id)){
                news.setAuthorId(null);
            }
        }
    }
}