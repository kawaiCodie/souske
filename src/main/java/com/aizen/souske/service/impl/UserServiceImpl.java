package com.aizen.souske.service.impl;

import com.aizen.souske.entity.User;
import com.aizen.souske.repo.UserRepo;
import com.aizen.souske.request.UserRequest;
import com.aizen.souske.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

}
