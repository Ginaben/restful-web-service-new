package com.example.restfulwebservicenew.controller;

import com.example.restfulwebservicenew.bean.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //GET
    // /hello-world (endpoint)
    //@RequestMapping(method=RequestMethod.GET, path="/hello-world")
    @GetMapping(path = "/hello-world")

    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
//        return new HelloWorldBean("Hello World, " + name);
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternatiojnalized(
            @RequestHeader(name = "Accept-Language", required = false)
            Locale locale) {
        return messageSource.getMessage("greeting.message", null, locale);
    }

}