package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Account")
@Getter @Setter
@NoArgsConstructor@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID", nullable = false, unique = true)
    private short id;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Username", nullable = false, unique = true)
    private String username;

    @Column(name = "Fullname", nullable = false)
    private String fullname;

    @ManyToOne
    @JoinColumn(name = "DepartmentID", nullable = false)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PositionID", nullable = false)
    private Position position;

    @Column(name = "CreateDate")
    private Date createDate;

}
