package com.mjc.school.service;

import com.mjc.school.service.actions.ValAuthorId;
import com.mjc.school.service.actions.ValAuthorParam;
import com.mjc.school.service.dto.NewsDtoReq;
import com.mjc.school.service.exeptions.NotFoundException;

import java.util.List;

public interface BaseService<T,  K> {
    List<T> readAll();

    T readById(K id) throws NotFoundException;

    T readById(Long id) throws NotFoundException;

    T create(T createRequest) throws NotFoundException;

    T update(T updateRequest) throws NotFoundException;

    boolean deleteById(K id) throws NotFoundException;


    @ValAuthorId
    boolean deleteById(Long id) throws NotFoundException;
}
