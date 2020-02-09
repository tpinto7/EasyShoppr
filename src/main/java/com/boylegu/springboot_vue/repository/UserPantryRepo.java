package com.boylegu.springboot_vue.repository;

import com.boylegu.springboot_vue.entities.User;
import com.boylegu.springboot_vue.entities.UserPantry;
import com.boylegu.springboot_vue.entities.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface UserPantryRepo extends JpaRepository<UserPantry, UUID> {
  List<UserPantry> findAllByUserId(UUID id);
  Optional<UserPantry> findOneByUserIdAndSku(UUID id, int sku);
}