package com.vtii.controller;

import com.vtii.dto.DepartmentDto;
import com.vtii.entity.Department;
import com.vtii.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/department")
@CrossOrigin("*")
public class DepartmentController{
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> getALlDepartment(){
        List<Department> departments = departmentService.getAllDepartment();
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        for (Department department:departments) {
            DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getName());
            departmentDtos.add(departmentDto);
        }
        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }
}
