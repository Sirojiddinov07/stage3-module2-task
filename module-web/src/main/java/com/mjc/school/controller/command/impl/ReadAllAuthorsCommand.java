package com.mjc.school.controller.command.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.Command;
import com.mjc.school.service.dto.AuthorDtoReq;
import com.mjc.school.service.dto.AuthorDtoRes;

public class ReadAllAuthorsCommand implements Command {
    private final BaseController<AuthorDtoReq, AuthorDtoRes, Long> controller;


    public ReadAllAuthorsCommand(BaseController<AuthorDtoReq, AuthorDtoRes, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.readAll().stream().forEach(System.out::println);
    }
}
