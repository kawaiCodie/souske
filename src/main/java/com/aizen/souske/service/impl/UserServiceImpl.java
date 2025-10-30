package com.aizen.souske.service.impl;

import com.aizen.souske.entity.User;
import com.aizen.souske.repo.UserRepo;
import com.aizen.souske.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

}
