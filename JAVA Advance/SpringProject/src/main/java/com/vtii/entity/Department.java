package com.vtii.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Account> account;
}
