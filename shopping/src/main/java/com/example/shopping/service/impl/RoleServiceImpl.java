package com.example.shopping.service.impl;

import com.example.shopping.entity.Role;
import com.example.shopping.repository.RoleRepository;
import com.example.shopping.service.RoleService;
import com.google.common.base.CaseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void createRole(String nameRole) {
        Role newRole = new Role();
        newRole.setName(nameRole);
        newRole.setValue(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, nameRole));
        roleRepository.save(newRole);
    }

    @Override
    public void updateRole(String id, Role role) {

    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role getByValue(String value) {
        return roleRepository.findByValue(value);
    }
}
