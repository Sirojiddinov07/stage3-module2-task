package com.mjc.school.controller.implement;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDtoReq;
import com.mjc.school.service.dto.NewsDtoRes;
import com.mjc.school.service.exeptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NewsController implements BaseController<NewsDtoReq, NewsDtoRes, Long> {

    private final BaseService<NewsDtoReq, NewsDtoRes, Long> newsService;

    @Autowired
    public NewsController(BaseService<NewsDtoReq, NewsDtoRes, Long> newsService) {
        this.newsService = newsService;
    }

    @Override
    public List<NewsDtoRes> readAll() {
        return  newsService.readAll();
    }

    @Override
    public NewsDtoRes readById(Long id) throws NotFoundException {
        return newsService.readById(id);
    }

    @Override
    public NewsDtoRes create(NewsDtoReq createRequest) throws NotFoundException {
        return newsService.create(createRequest);
    }

    @Override
    public NewsDtoRes update(NewsDtoReq updateRequest) throws NotFoundException {
        return newsService.update(updateRequest);
    }

    @Override
    public boolean deleteById(Long id) throws NotFoundException {
        return newsService.deleteById(id);
    }




}
