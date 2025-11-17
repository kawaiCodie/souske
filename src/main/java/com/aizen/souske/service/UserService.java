package com.aizen.souske.service;

import com.aizen.souske.entity.User;
import com.aizen.souske.request.UserRequest;
import com.aizen.souske.request.UserUpdateRequest;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void addnewUser(UserRequest userRequest);

    User getUserById(String id);

    UserUpdateRequest updateUser(String id, UserUpdateRequest user);

    void deleteUser(String id);
}
