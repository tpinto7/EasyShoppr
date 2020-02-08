package com.boylegu.springboot_vue.controller.dto.response;

import com.boylegu.springboot_vue.dto.UserDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class UserListResponseDto {
    List<UserDto> data;
}
