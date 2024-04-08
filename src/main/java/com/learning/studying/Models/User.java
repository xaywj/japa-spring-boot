package com.learning.studying.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class User extends BaseEntity {
    private Long id;

    @Column()
    private String username;

    @Column()
    private String password;

    @Column()
    private String name;

    @Column
    private String profileImagePath; // Add this field to store the path to the profile image

}
