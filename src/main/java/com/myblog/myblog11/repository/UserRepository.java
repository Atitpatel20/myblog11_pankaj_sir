package com.myblog.myblog11.repository;

import com.myblog.myblog11.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findByName(String name);
    Optional<User> findByUsernameOrEmail(String username,String email);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
