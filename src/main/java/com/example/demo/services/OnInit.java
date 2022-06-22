package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.model.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

@Component
public class OnInit {

    private final UserService userService;

    @Autowired
    public OnInit(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void afterBoot() {
        for (int i = 0; i < 3; i++) {
            this.userService.addUser(new User("test" + i + "@test.com", "test_user" + i, UserStatus.Active));
        }
        for (int i = 0; i < 3; i++) {
            this.userService.addUser(new User("test" + i + 3 + "@test.com", "test_user" + i + 3, UserStatus.Inactive));
        }

    }
}
