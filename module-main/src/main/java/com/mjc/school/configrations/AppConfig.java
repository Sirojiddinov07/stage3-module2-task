package com.mjc.school.configrations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({
        "com.mjc.school",
        "com.mjc.school.repository",
        "com.mjc.school.service",
        "com.mjc.school.controller"
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig
{
}



