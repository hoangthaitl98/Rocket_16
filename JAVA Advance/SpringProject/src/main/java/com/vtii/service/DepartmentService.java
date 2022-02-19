package com.vtii.service;

import com.vtii.entity.Department;
import com.vtii.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService{
    @Autowired
    private IDepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
}
