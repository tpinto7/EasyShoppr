package com.boylegu.springboot_vue.service.user;

import com.boylegu.springboot_vue.controller.dto.request.LoginRequestDto;
import com.boylegu.springboot_vue.controller.dto.request.UserCreateDto;
import com.boylegu.springboot_vue.controller.dto.response.UserListResponseDto;
import com.boylegu.springboot_vue.dto.UserDto;

import java.util.UUID;

public interface UserService {
    UserListResponseDto getUserList() throws Exception;
    UserDto getUserById(UUID id) throws Exception;
    UserDto createUser(UserCreateDto userCreateDto);
    UserDto createPassword(final UUID userId, final String Password) throws Exception;
    void login(LoginRequestDto loginDto) throws Exception;
}
