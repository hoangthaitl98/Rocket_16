package com.vtii.service;

import java.util.List;

import com.vtii.entity.Account;
import com.vtii.form.AccountFormForCreating;
import com.vtii.form.AccountFormForCreatingRegister;
import com.vtii.form.AccountFormForUpdating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface IAccountService extends UserDetailsService {
	public List<Account> getAllAccount();

	public Account getAccountById(short id);

	public void createAccount(AccountFormForCreating form);

	public void updateAccount(short id, AccountFormForUpdating form);

	public void deleteAccount(short id);

	public Account getAccountByUsername(String username);

	public void createAccountRegister(AccountFormForCreatingRegister form);

	public void activeUser(String token);

	public Account getAccountByEmail(String email);
	public boolean existsByUsername(String name);
	public boolean existsByEmail(String email);
}
