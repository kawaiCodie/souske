package com.aizen.souske.controllers;

import com.aizen.souske.entity.User;
import com.aizen.souske.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping("/allUsers")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }
}
