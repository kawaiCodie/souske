package com.aizen.souske.service.impl;

import com.aizen.souske.Exception.ResourceNotFoundException;
import com.aizen.souske.entity.User;
import com.aizen.souske.repo.UserRepo;
import com.aizen.souske.request.UserRequest;
import com.aizen.souske.request.UserUpdateRequest;
import com.aizen.souske.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;


    @Override
    public void addnewUser(UserRequest userRequest) {
        User user = new User();
        user.setUserName(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.activate();
        userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

    @Override
    public User getUserById(String id) {
        Optional<User> user = userRepo.findByUserIdAndStatus(Integer.parseInt(id), 'A');
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    @Override
    public UserUpdateRequest updateUser(String id, UserUpdateRequest userRequest) {

        Optional<User> currentUser = userRepo.findByUserIdAndStatus(
                Integer.parseInt(id), 'A');

        if (!currentUser.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        User user = currentUser.get();

        if (userRequest.getUserName() != null) {
            user.setUserName(userRequest.getUserName());
        }

        if (userRequest.getEmail() != null) {
            user.setEmail(userRequest.getEmail());
        }

        User updatedUser= userRepo.save(user);
        BeanUtils.copyProperties(updatedUser, userRequest);
        return userRequest;
    }

    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(Integer.parseInt(id));
    }

}
