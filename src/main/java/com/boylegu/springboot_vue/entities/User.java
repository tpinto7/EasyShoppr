package com.boylegu.springboot_vue.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "User")
public class User {
    private static final String COLUMN_NAME_USERNAME = "username";
    private static final String COLUMN_NAME_FIRST_NAME = "first_name";
    private static final String COLUMN_NAME_LAST_NAME = "last_name";
    private static final String COLUMN_NAME_EMAIL_ADDRESS = "email_address";
    private static final String COLUMN_NAME_PANTRY = "pantry";

    // TODO add one to one to password reset token
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = COLUMN_NAME_USERNAME)
    private String username;

    @Column(name = COLUMN_NAME_FIRST_NAME)
    private String firstName;

    @Column(name = COLUMN_NAME_LAST_NAME)
    private String lastName;

    @NotBlank
    @Column(name = COLUMN_NAME_EMAIL_ADDRESS)
    private String emailAddress;

//    @javax.persistence.OneToMany(cascade = CascadeType.ALL)
//    @javax.persistence.MapKey(name = "value")
//    private Map<Integer, UserPantry> permissions = new HashMap<Integer, UserPantry>(0);
}
