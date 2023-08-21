package com.mjc.school.controller.command.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.Command;
import com.mjc.school.service.dto.NewsDtoReq;
import com.mjc.school.service.dto.NewsDtoRes;

public class ReadAllNewsCommand implements Command {
    private final BaseController<NewsDtoReq, NewsDtoRes, Long> controller;

    public ReadAllNewsCommand(BaseController<NewsDtoReq, NewsDtoRes, Long> controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.readAll().stream().forEach(System.out::println);
    }
}
