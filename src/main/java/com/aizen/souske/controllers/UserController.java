package com.aizen.souske.controllers;

import com.aizen.souske.entity.User;
import com.aizen.souske.request.UserRequest;
import com.aizen.souske.request.UserUpdateRequest;
import com.aizen.souske.response.Response;
import com.aizen.souske.service.UserService;
import jakarta.validation.Valid;
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

    @PostMapping("/addUser")
    public Response addUser(@RequestBody UserRequest userRequest) {
        userService.addnewUser(userRequest);
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

    @PutMapping("/{id}")
    public Response updateUser(@PathVariable String id,@Valid @RequestBody UserUpdateRequest request) {
        UserUpdateRequest updatedUser = userService.updateUser(id, request);
        return Response.builder()
                .status("200")
                .data(updatedUser)
                .build();
    }
}
