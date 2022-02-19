package com.vtii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtii.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Short>{

}
