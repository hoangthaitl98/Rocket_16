package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Position", catalog = "testingsystem")
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PositionID")
    private short id;

    @Column(name = "PositionName", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PositionName positionName;

    private enum PositionName{
        Dev, Test, Master, PM
    }

    @OneToMany(mappedBy = "position")
    List<Account> accounts;
}
