package com.vti.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Department", catalog = "testing_system")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Department implements Serializable {
    @Id
    @Column(name = "DepartmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "DepartmentName", nullable = false)
    private String name;
}
