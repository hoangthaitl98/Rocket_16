package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Department", catalog = "testingsystem")
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentID")
    private short id;

    @Column(name = "DepartmentName", nullable = false, unique = true)
    private String name;

    public Department(String name) {
        this.name = name;
    }
}
