package com.vtii.controller;

import com.vtii.form.AccountFormForCreatingRegister;
import com.vtii.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/accountRegister")
@CrossOrigin("*")
public class AccountRegisterController {
    @Autowired
    private IAccountService accountService;

    @PostMapping
    public ResponseEntity<?> createRegisterAccount(@RequestBody AccountFormForCreatingRegister form){
        accountService.createAccountRegister(form);
        return new ResponseEntity<String>("We have sent an email. Please check email to active your account!",
                HttpStatus.CREATED);
    }

    @GetMapping("/activeUser")
    public ResponseEntity<?> activeUserViaEmail(@RequestParam String token){
        accountService.activeUser(token);
        return new ResponseEntity<>("Active success!", HttpStatus.OK);
    }
}
