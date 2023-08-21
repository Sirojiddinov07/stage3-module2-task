package com.mjc.school.controller.implement;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDtoRes;
import com.mjc.school.service.dto.AuthorDtoReq;
import com.mjc.school.service.exeptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public  class AuthorController implements BaseController<AuthorDtoReq, AuthorDtoReq, Long> {
    private final BaseService<AuthorDtoReq, AuthorDtoRes, Long> authorService;

    @Autowired
    public AuthorController(BaseService<AuthorDtoReq, AuthorDtoRes, Long> authorService) {
        this.authorService = authorService;
    }

    @Override
    public List<AuthorDtoReq> readAll() {
        return authorService.readAll();
    }

    @Override
    public AuthorDtoReq readById(Long id) throws NotFoundException {
        return authorService.readById(id);
    }

    @Override
    public AuthorDtoReq create(AuthorDtoReq createRequest) throws NotFoundException {
        return authorService.create(createRequest);
    }

    @Override
    public AuthorDtoReq update(AuthorDtoReq updateRequest) throws NotFoundException {
        return authorService.update(updateRequest);
    }

    @Override
    public boolean deleteById(Long id) throws NotFoundException {
        return authorService.deleteById(id);
    }
}
