package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Position", catalog = "TestingSystem")
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PositionID")
    private short id;

    @Column(name = "PositionName", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PositionName positionName;

    public enum PositionName{
        Dev, Test, Master, PM;
    }

    @OneToMany(mappedBy = "position")
    List<Account> accounts;
}
