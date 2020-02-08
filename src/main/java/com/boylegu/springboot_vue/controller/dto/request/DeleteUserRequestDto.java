package com.boylegu.springboot_vue.controller.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
public class DeleteUserRequestDto {
    @NotNull
    private List<UUID> users;
}
