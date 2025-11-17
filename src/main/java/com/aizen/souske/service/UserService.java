package com.aizen.souske.service;

import com.aizen.souske.entity.User;
import com.aizen.souske.request.UserRequest;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void registerNewUser(UserRequest userRequest);

    User getUserById(String id);
}
