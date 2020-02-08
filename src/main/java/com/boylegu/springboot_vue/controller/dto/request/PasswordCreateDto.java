package com.boylegu.springboot_vue.controller.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class PasswordCreateDto {
    @NotNull
    private String password;
}

