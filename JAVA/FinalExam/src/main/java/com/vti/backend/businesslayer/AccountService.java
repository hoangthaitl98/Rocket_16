/*
package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IRepository;
import com.vti.entity.Account;
import com.vti.entity.User;

import java.util.ArrayList;
import java.util.List;

public class AccountService implements IService{
    IRepository repository;

    public AccountService(){
        repository = new AccountRepository();
    }

    public List<Account> getListAccount(){
        List<Account> accountList = new ArrayList<>();
        for (int i = 0; i < repository.getListAccount().size(); i++) {
            accountList.add(repository.getListAccount().get(i));
        }
        return accountList;
    }

    @Override
    public boolean createAccount(String fullname, String email, String username) {
        return repository.createAccount(fullname, email, username);
    }

    @Override
    public Account getAccountById(int id) {
        return repository.getAccountById(id);
    }

    public boolean isAccountExist(String username){
        if (repository.isAccountExist(username) == true){
            return true;
        }else return false;
    }

    @Override
    public Account updateAccountById(int id, String email, String fullname, String username) {
        return repository.updateAccountById(id, email, fullname, username);
    }

    @Override
    public boolean deleteAccount(int id) {
        return repository.deleteAccount(id);
    }
}
*/
