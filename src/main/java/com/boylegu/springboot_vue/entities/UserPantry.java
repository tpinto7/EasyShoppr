package com.boylegu.springboot_vue.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "UserPantry")
public class UserPantry {
    private static final String COLUMN_NAME_USER = "local_user_id";
    private static final String COLUMN_NAME_SKU = "sku";
    private static final String COLUMN_NAME_VALUE = "value";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

 @Column(name = COLUMN_NAME_USER)
    private UUID userId;

    @Column(name = COLUMN_NAME_SKU)
    private int sku;

    @Column(name = COLUMN_NAME_VALUE)
    private int value;
}
