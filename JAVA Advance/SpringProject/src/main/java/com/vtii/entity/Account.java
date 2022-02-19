package com.vtii.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "`Account`",catalog = "testingsystem")
@Getter @Setter
@NoArgsConstructor@AllArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

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
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PositionID", nullable = false)
    private Position position;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "Password")
    private String password;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "`status`", nullable = false)
    private AccountStatus status = AccountStatus.NOT_ACTIVE;

    public enum AccountStatus{
        NOT_ACTIVE, ACTIVE;
    }
}
