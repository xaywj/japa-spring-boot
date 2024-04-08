package com.learning.studying.Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Upload extends BaseEntity {
    private Long id;
    @Column()
    private String fileName;

    @Column()
    private String filePath;
}
