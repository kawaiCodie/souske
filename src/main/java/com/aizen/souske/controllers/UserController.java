package com.aizen.souske.controllers;

import com.aizen.souske.entity.User;
import com.aizen.souske.request.UserRequest;
import com.aizen.souske.response.Response;
import com.aizen.souske.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/allUsers")
    public Response getAllUsers() {
        List<User> users = userService.getUsers();
        return Response.builder()
                .status("200")
                .data(users)
                .build();
    }

    @PostMapping("/register")
    public Response registerUser(@RequestBody UserRequest userRequest) {
        userService.registerNewUser(userRequest);
        return Response.builder()
                .status("200")
                .build();
    }

    @GetMapping("/{id}")
    public Response getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        return Response.builder()
                .status("200")
                .data(user)
                .build();
    }
}
