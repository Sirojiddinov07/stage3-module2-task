package com.mjc.school;

import com.mjc.school.configrations.AppConfig;
import com.mjc.school.controller.view.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        View menu = applicationContext.getBean(View.class);
        menu.menuScreen();


    }
}
