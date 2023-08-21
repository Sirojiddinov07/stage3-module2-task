package com.mjc.school.controller.command.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.AbstractCommand;
import com.mjc.school.controller.command.Command;
import com.mjc.school.controller.options.Options;
import com.mjc.school.controller.utils.Util;
import com.mjc.school.service.dto.NewsDtoReq;
import com.mjc.school.service.dto.NewsDtoRes;
import com.mjc.school.service.exeptions.InvaliDataException;
import com.mjc.school.service.exeptions.NotFoundException;


import java.util.Scanner;

public class DeleteNewsByIdCommand extends AbstractCommand<NewsDtoReq, NewsDtoRes, Long> implements Command {
    public DeleteNewsByIdCommand(BaseController controller, Scanner scanner) {
        super(controller, scanner);
    }

    @Override
    public void execute() throws InvaliDataException, NotFoundException {
        System.out.println(Options.ENTER_ID);
        System.out.println(getController().deleteById(Util.getUserInput(getInput())));
    }
}
