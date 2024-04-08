package com.learning.studying.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity()
@Data()
public class Department extends BaseEntity{
    private Long id;
    @Column()
    private String department_name;
    @Column()
    private String description;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<User> users;
}
