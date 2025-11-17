package com.aizen.souske.service.impl;

import com.aizen.souske.Exception.ResourceNotFoundException;
import com.aizen.souske.entity.User;
import com.aizen.souske.repo.UserRepo;
import com.aizen.souske.request.UserRequest;
import com.aizen.souske.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;


    @Override
    public void addnewUser(UserRequest userRequest){
        User user = new User();
        user.setUserName(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.activate();
        userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetch all users");
        return userRepo.findAll();
    }

    @Override
    public User getById(Integer id) {
        log.info("Fetch user By Id");
        User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
        return user;
    }

}
