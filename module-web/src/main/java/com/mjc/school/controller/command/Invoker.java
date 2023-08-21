package com.mjc.school.controller.command;

import com.mjc.school.service.exeptions.InvaliDataException;
import com.mjc.school.service.exeptions.NotFoundException;
import org.springframework.stereotype.Component;

@Component
public class Invoker {
    private Command command;
    public void setCommand(Command command) throws NotFoundException, InvaliDataException {
        this.command = command;
        execute();
    }

    private void execute() throws NotFoundException, InvaliDataException {
        command.execute();
    }
}
