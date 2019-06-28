package com.css.security.demo.controller;

import com.css.security.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("hello")
    public User helloUser(){
        User user = new User();
        user.setId("2004050832");
        user.setUsername("王位");
        user.setPassword("luck");
        user.setBirthday(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return user;
    }
}
