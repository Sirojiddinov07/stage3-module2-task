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
public class NewsController implements BaseController<NewsDtoReq, NewsDtoReq, Long> {

    private final BaseService<NewsDtoReq, NewsDtoRes, Long> newsService;

    @Autowired
    public NewsController(BaseService<NewsDtoReq, NewsDtoRes, Long> newsService) {
        this.newsService = newsService;
    }

    @Override
    public List<NewsDtoReq> readAll() {
        return  newsService.readAll();
    }

    @Override
    public NewsDtoReq readById(Long id) throws NotFoundException {
        return newsService.readById(id);
    }

    @Override
    public NewsDtoReq create(NewsDtoReq createRequest) throws NotFoundException {
        return newsService.create(createRequest);
    }

    @Override
    public NewsDtoReq update(NewsDtoReq updateRequest) throws NotFoundException {
        return newsService.update(updateRequest);
    }

    @Override
    public boolean deleteById(Long id) throws NotFoundException {
        return newsService.deleteById(id);
    }
}
