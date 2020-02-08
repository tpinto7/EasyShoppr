package com.boylegu.springboot_vue.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "UserPassword")
public class UserPassword {
    private static final String COLUMN_NAME_PASSWORD = "password";
    private static final String COLUMN_NAME_SALT = "salt";
    private static final String COLUMN_NAME_LOCAL_USER = "local_user_id";
    private static final String COLUMN_NAME_EFFECTIVE_DATETIME = "effective_datetime";
    private static final String COLUMN_NAME_INEFFECTIVE_DATETIME = "ineffective_datetime";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = COLUMN_NAME_PASSWORD)
    private byte[] password;

    @Column(name = COLUMN_NAME_SALT)
    private byte[] salt;

    @Column(name = COLUMN_NAME_EFFECTIVE_DATETIME)
    private LocalDateTime effective;

    @Column(name = COLUMN_NAME_INEFFECTIVE_DATETIME)
    private LocalDateTime ineffective;

    @ManyToOne
    @JoinColumn(name=COLUMN_NAME_LOCAL_USER, nullable=false)
    private User user;
}
