package com.boylegu.springboot_vue.service.user;

import com.boylegu.springboot_vue.controller.dto.request.LoginRequestDto;
import com.boylegu.springboot_vue.controller.dto.request.UserCreateDto;
import com.boylegu.springboot_vue.controller.dto.response.UserListResponseDto;
import com.boylegu.springboot_vue.dto.UserDto;
import com.boylegu.springboot_vue.dto.UserPantryDto;
import com.boylegu.springboot_vue.entities.UserPantry;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface UserService {
    UserListResponseDto getUserList() throws Exception;
    UserDto getUserById(UUID id) throws Exception;
    List<UserPantry> getUserPantry(UUID id) throws Exception;
    UserDto createUser(UserCreateDto userCreateDto);
    void addToPantry(UUID userId, int sku, int value, String unit, String name);
    UserDto createPassword(final UUID userId, final String Password) throws Exception;
    UserDto login(LoginRequestDto loginDto) throws Exception;
}
