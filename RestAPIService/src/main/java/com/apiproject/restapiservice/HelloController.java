package com.apiproject.restapiservice;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
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
}
