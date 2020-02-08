package com.boylegu.springboot_vue.controller.dto.response;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class DeleteUserResponseDto {
    private UUID accessingEntityId;
    private UUID userId;
    private Boolean success;
//    private List<ErrorData> errors;
}
