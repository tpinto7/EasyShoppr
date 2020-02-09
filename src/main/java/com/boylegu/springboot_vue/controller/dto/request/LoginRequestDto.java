package com.boylegu.springboot_vue.controller.dto.request;

import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Getter
public class LoginRequestDto {
    @NotNull
    String email;
    @NotEmpty
    String password;
}
