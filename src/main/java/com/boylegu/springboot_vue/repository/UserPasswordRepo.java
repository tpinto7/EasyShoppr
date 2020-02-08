package com.boylegu.springboot_vue.repository;

import com.boylegu.springboot_vue.entities.User;
import com.boylegu.springboot_vue.entities.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserPasswordRepo extends JpaRepository<UserPassword, UUID> {
    List<UserPassword> findByUserAndIneffectiveIsNull(User user);
    Optional<UserPassword> findByUserIdAndIneffectiveIsNull(UUID id);
}
