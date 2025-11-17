package com.aizen.souske.repo;

import com.aizen.souske.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUserIdAndStatus(Integer userId, char status);
}
