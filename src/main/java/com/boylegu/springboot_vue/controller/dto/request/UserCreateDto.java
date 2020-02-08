package com.boylegu.springboot_vue.controller.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
public class UserCreateDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String emailAddress;
}