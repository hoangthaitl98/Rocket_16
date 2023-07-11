package com.example.shopping.controller;

import com.example.shopping.entity.Role;
import com.example.shopping.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/role")
@CrossOrigin("*")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<?> getAllRole(@RequestHeader(name = "Authorization", defaultValue = "Bearer ", required = false) String token) {
        List<Role> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createRole(@RequestHeader(name = "Authorization", defaultValue = "Bearer ", required = false) String token, @RequestBody String name) {
        roleService.createRole(name);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteRole(@RequestHeader(name = "Authorization", defaultValue = "Bearer ", required = false) String token, @PathVariable Long id) {
        roleService.deleteRole(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
