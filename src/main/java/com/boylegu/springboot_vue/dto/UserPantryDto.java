package com.boylegu.springboot_vue.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class UserPantryDto {
    private int sku;
    private int value;
    private String name;
    private String unit;
}
