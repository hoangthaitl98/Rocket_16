package com.example.shopping.service;

import com.example.shopping.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    void createRole(String nameRole);

    void updateRole(String id, Role role);

    void deleteRole(Long id);

    Role getByValue(String value);
}
