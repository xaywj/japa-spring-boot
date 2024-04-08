package com.learning.studying.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Book extends BaseEntity {
    private Long id;
    @Column()
    private String title;
    @Column()
    private String author;
    @Column()
    private String isbn;
    @Column()
    private String file;
    // constructors, getters, setters
}