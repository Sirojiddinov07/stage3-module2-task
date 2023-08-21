package com.mjc.school.controller.command.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.AbstractCommand;
import com.mjc.school.controller.command.Command;
import com.mjc.school.controller.options.Options;
import com.mjc.school.service.dto.AuthorDtoReq;
import com.mjc.school.service.dto.AuthorDtoRes;
import com.mjc.school.service.exeptions.NotFoundException;

import java.util.Scanner;

public class CreateAuthorCommand extends AbstractCommand <AuthorDtoReq, AuthorDtoRes, Long>implements Command {

    public CreateAuthorCommand(BaseController<AuthorDtoReq, AuthorDtoRes, Long> controller, Scanner scanner) {
        super(controller, scanner);
    }

    @Override
    public void execute() throws NotFoundException {
        System.out.println(Options.ENTER_AUTHOR_NAME);
        String name = getInput().nextLine();
        AuthorDtoReq authorDtoRequest = new AuthorDtoReq();
        authorDtoRequest.setName(name);
        System.out.println(getController().create(authorDtoRequest));
    }
}
