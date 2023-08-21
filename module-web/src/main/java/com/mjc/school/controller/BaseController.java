package com.mjc.school.controller;

import com.mjc.school.service.exeptions.NotFoundException;

import java.util.List;

public interface BaseController<T, R, K> {

    List<R> readAll();

    R readById(K id) throws NotFoundException;

    R create(T createRequest) throws NotFoundException;

    R update(T updateRequest) throws NotFoundException;

    boolean deleteById(K id) throws NotFoundException;
}
