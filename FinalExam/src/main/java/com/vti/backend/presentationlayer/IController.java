package com.vti.backend.presentationlayer;

import com.vti.entity.Account;

import java.util.List;

public interface IController {
    public List<Account> getListAccount();

    public boolean createAccount(String fullname, String email, String username);

    public Account getAccountById(int id);

    public boolean isAccountExist(String username);

    public Account updateAccountById(int id, String email, String fullname, String username);

    public boolean deleteAccount(int id);
}
