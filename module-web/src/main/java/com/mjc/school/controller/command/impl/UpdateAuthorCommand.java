package com.mjc.school.controller.command.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.AbstractCommand;
import com.mjc.school.controller.command.Command;
import com.mjc.school.controller.options.Options;
import com.mjc.school.controller.utils.Util;
import com.mjc.school.service.dto.AuthorDtoReq;
import com.mjc.school.service.dto.AuthorDtoRes;
import com.mjc.school.service.exeptions.InvaliDataException;
import com.mjc.school.service.exeptions.NotFoundException;

import java.util.Scanner;

public class UpdateAuthorCommand extends AbstractCommand<AuthorDtoReq, AuthorDtoRes, Long> implements Command {
    public UpdateAuthorCommand(BaseController<AuthorDtoReq, AuthorDtoRes, Long> controller, Scanner scanner) {
        super(controller, scanner);
    }

    @Override
    public void execute() throws InvaliDataException, NotFoundException {
        AuthorDtoReq authorRequest = new AuthorDtoReq();
        System.out.println(Options.ENTER_AUTHOR_ID);
        Long id = Util.getUserInput(getInput());
        System.out.println(Options.ENTER_AUTHOR_NAME);
        String name = getInput().nextLine();
        authorRequest.setId(id);
        authorRequest.setName(name);
        System.out.println(getController().update(authorRequest));

    }
}
