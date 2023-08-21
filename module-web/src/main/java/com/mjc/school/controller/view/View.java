package com.mjc.school.controller.view;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.Invoker;
import com.mjc.school.controller.command.impl.*;

import com.mjc.school.controller.options.Options;
import com.mjc.school.service.dto.AuthorDtoReq;
import com.mjc.school.service.dto.AuthorDtoRes;
import com.mjc.school.service.dto.NewsDtoReq;
import com.mjc.school.service.dto.NewsDtoRes;
import com.mjc.school.service.exeptions.InvaliDataException;
import com.mjc.school.service.exeptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class View {
    private final BaseController<AuthorDtoReq, AuthorDtoRes, Long> authorController;
    private final BaseController<NewsDtoReq, NewsDtoRes, Long> newsController;
    private final Invoker invoker;
    Scanner input = new Scanner(System.in);

    @Autowired
    public View(BaseController<AuthorDtoReq, AuthorDtoRes, Long> authorController, BaseController<NewsDtoReq, NewsDtoRes, Long> newsController, Invoker invoker) {
        this.authorController = authorController;
        this.newsController = newsController;
        this.invoker = invoker;
    }


    public void menuScreen() {

        while (true) {
            try {
                System.out.println(Options.START_MENU_TEXT);
                switch (input.nextLine()) {
                    case "1" -> invoker.setCommand(new ReadAllNewsCommand(newsController));
                    case "2" -> invoker.setCommand(new ReadAllAuthorsCommand(authorController));
                    case "3" -> invoker.setCommand(new ReadNewsByIdCommand(newsController, input));
                    case "4" -> invoker.setCommand(new ReadAuthorByIdCommand(authorController, input));
                    case "5" -> invoker.setCommand(new CreateNewsCommand(newsController, input));
                    case "6" -> invoker.setCommand(new CreateAuthorCommand(authorController, input));
                    case "7" -> invoker.setCommand(new UpdateNewsCommand(newsController, input));
                    case "8" -> invoker.setCommand(new UpdateAuthorCommand(authorController, input));
                    case "9" -> invoker.setCommand(new DeleteNewsByIdCommand(newsController, input));
                    case "10" -> invoker.setCommand(new DeleteAuthorByIdCommand(authorController, input));
                    case "0" -> exitProgram();
                    default ->  System.out.println(Options.OPERATION_ERROR);
                }
            } catch (InvaliDataException e) {
                System.out.println(e.getMessage());
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void exitProgram() {
        System.out.println(Options.OPERATION_EXIT);
        System.exit(0);
    }
}

