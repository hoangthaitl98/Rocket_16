package com.vtii.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Position", catalog = "testingsystem")
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class Position implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PositionID")
    private short id;

    @Column(name = "PositionName", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PositionName positionName;

    public enum PositionName{
        Dev, Test, Scrum_Master, PM;
    	@Override
    	public String toString() {
    		// TODO Auto-generated method stub
    		return super.toString();
    	}
    }

    @OneToMany(mappedBy = "position")
    List<Account> accounts;
}
