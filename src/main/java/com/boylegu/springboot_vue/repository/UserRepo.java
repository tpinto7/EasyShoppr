package com.boylegu.springboot_vue.repository;

import com.boylegu.springboot_vue.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    Optional<User> findOneById(UUID id);
    Optional<User> findOneByEmailAddress(String username);
}
