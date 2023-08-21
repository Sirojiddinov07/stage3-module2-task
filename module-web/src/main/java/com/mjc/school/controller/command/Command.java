package com.mjc.school.controller.command;

import com.mjc.school.service.exeptions.InvaliDataException;
import com.mjc.school.service.exeptions.NotFoundException;

public interface Command {
    void execute() throws NotFoundException, InvaliDataException;
}
