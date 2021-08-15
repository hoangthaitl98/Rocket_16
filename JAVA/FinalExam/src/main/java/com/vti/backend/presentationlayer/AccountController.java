/*
package com.vti.backend.presentationlayer;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.IService;
import com.vti.entity.Account;
import com.vti.entity.User;

import java.util.List;

public class AccountController implements IController{
    IService service;

    public AccountController(){
        service = new AccountService();
    }

    @Override
    public List<Account> getListAccount() {
        return service.getListAccount();
    }

    @Override
    public boolean createAccount(String fullname, String email, String username) {
        return service.createAccount(fullname, email, username);
    }

    @Override
    public Account getAccountById(int id) {
        return service.getAccountById(id);
    }

    @Override
    public boolean isAccountExist(String username) {
        if (service.isAccountExist(username) == true){
            return true;
        }
        else return false;
    }

    @Override
    public Account updateAccountById(int id, String email, String fullname, String username) {
        return service.updateAccountById(id, email, fullname, username);
    }

    @Override
    public boolean deleteAccount(int id) {
        return service.deleteAccount(id);
    }
}
*/
