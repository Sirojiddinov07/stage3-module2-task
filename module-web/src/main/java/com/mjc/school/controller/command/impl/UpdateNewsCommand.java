package com.mjc.school.controller.command.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.AbstractCommand;
import com.mjc.school.controller.command.Command;
import com.mjc.school.controller.utils.Util;
import com.mjc.school.controller.options.Options;
import com.mjc.school.service.dto.NewsDtoReq;
import com.mjc.school.service.dto.NewsDtoRes;
import com.mjc.school.service.exeptions.InvaliDataException;
import com.mjc.school.service.exeptions.NotFoundException;

import java.util.Scanner;

public class UpdateNewsCommand extends AbstractCommand<NewsDtoReq, NewsDtoRes, Long> implements Command {

    public UpdateNewsCommand(BaseController<NewsDtoReq, NewsDtoRes, Long> controller, Scanner scanner) {
        super(controller, scanner);
    }

    @Override
    public void execute() throws InvaliDataException, NotFoundException {
        NewsDtoReq newsDtoRequest = new NewsDtoReq();
        System.out.println(Options.ENTER_ID);
        Long id = Util.getUserInput(getInput());
        System.out.println(Options.ENTER_TITLE);
        String title = getInput().nextLine();
        System.out.println(Options.ENTER_CONTENT);
        String content = getInput().nextLine();
        System.out.println(Options.ENTER_AUTHOR_ID);
        Long authorId = Util.getUserInput(getInput());
        newsDtoRequest.setAuthorId(id);
        newsDtoRequest.setTitle(title);
        newsDtoRequest.setContent(content);
        newsDtoRequest.setAuthorId(authorId);
        System.out.println(getController().update(newsDtoRequest));

    }
}
