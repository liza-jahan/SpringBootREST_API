package com.apiproject.restapiservice;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.Locale;

@RestController
public class HelloController {
    private MessageSource messageSource;

    public HelloController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-world")
    public String helloController() {

        return "Hello-world";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloControllerBean() {

        return new HelloWorldBean("Hello-world");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {

        return new HelloWorldBean(String.format("Hello-world,%s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {

        Locale locale = LocaleContextHolder.getLocale();//What is the default locale in spring boot?Spring Boot application by default takes the message sources from src/main/resources folder under the classpath. The default locale message file name should be message. properties and files for each locale should name as messages_XX.
        return messageSource.getMessage("good.morning.message", null, "Default message", locale);
        /*    return "Hello-world";*/
        //good.morning.message
    }
}
