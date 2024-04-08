package com.learning.studying.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity()
@Data()
public class Business extends BaseEntity{
    private Long id;
    @Column()
    private String business_name;
    @Column()
    private String description;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL)
    private List<Department> departments;
}
