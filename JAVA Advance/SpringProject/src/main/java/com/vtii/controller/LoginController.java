package com.vtii.controller;

import com.vtii.dto.LoginInfoDto;
import com.vtii.entity.Account;
import com.vtii.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private IAccountService accountService;

    @GetMapping
    public ResponseEntity<?> login(Principal principal){
        String username = principal.getName();
        Account entity = accountService.getAccountByUsername(username);
        LoginInfoDto dto = new LoginInfoDto(entity.getId(), entity.getUsername(), entity.getFullname(), entity.getPassword());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
