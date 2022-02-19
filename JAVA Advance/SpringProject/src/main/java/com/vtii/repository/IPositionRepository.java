package com.vtii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtii.entity.Position;

public interface IPositionRepository extends JpaRepository<Position, Short>{

}
