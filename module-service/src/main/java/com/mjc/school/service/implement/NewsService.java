package com.mjc.school.service.implement;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.actions.ValNewsId;
import com.mjc.school.service.actions.ValNewsParam;
import com.mjc.school.service.dto.NewsDtoReq;
import com.mjc.school.service.exeptions.ErrorCodes;
import com.mjc.school.service.exeptions.NotFoundException;
import com.mjc.school.service.map.CustomNewsMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class NewsService implements BaseService<NewsDtoReq, Long> {

    public static final String AUTHOR = "Author";
    public static final String NEWS_ID = "News id";


    private final BaseRepository<NewsModel,Long> newsRepository;
    private final BaseRepository<AuthorModel, Long> authorRepository;

    @Autowired
    public NewsService(BaseRepository<NewsModel, Long> newsRepository, BaseRepository<AuthorModel, Long> authorRepository) {
        this.newsRepository = newsRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<NewsDtoReq> readAll() {
        return newsRepository.readAll().stream().map(CustomNewsMapper.INSTANCE::mapNewsModelToDtoResponse).toList();
    }

    @Override
    @ValNewsId
    public NewsDtoReq readById(Long id) throws NotFoundException {
        Optional<NewsModel> newsModel = newsRepository.readById(id);
        if (newsModel.isPresent()) {
            return CustomNewsMapper.INSTANCE.mapNewsModelToDtoResponse(newsModel.get());
        }
        throw new NotFoundException(
                String.format(ErrorCodes.NOT_FOUND_DATA.getMessage(), AUTHOR, id));
    }

    @Override
    @ValNewsParam
    public NewsDtoReq create(NewsDtoReq createRequest) throws NotFoundException {
        if(authorRepository.existById(createRequest.getAuthorId())){
            NewsModel newsModel = newsRepository.create(CustomNewsMapper.INSTANCE.mapDtoRequestToNewsModel(createRequest));
            return CustomNewsMapper.INSTANCE.mapNewsModelToDtoResponse(newsModel);
        }
        throw new NotFoundException(
                String.format(ErrorCodes.NOT_FOUND_DATA.getMessage(), AUTHOR, createRequest.getAuthorId()));
    }

    @Override
    @ValNewsParam
    public NewsDtoReq update(NewsDtoReq updateRequest) throws NotFoundException {
        if(newsRepository.existById(updateRequest.getId())){
            NewsModel newsModel = newsRepository.update(CustomNewsMapper.INSTANCE.mapDtoRequestToNewsModel(updateRequest));
            return CustomNewsMapper.INSTANCE.INSTANCE.mapNewsModelToDtoResponse(newsModel);
        }
        throw new NotFoundException(
                String.format(ErrorCodes.NOT_FOUND_DATA.getMessage(), NEWS_ID, updateRequest.getId()));
    }

    @Override
    @ValNewsId
    public boolean deleteById(Long id) throws NotFoundException {
        if(newsRepository.existById(id)){

            return newsRepository.deleteById(id);
        }
        throw new NotFoundException(
                String.format(ErrorCodes.NOT_FOUND_DATA.getMessage(), NEWS_ID, id));
    }
}