package com.vtii.service;

import java.util.List;
import java.util.UUID;

import com.vtii.entity.Department;
import com.vtii.entity.Position;
import com.vtii.entity.RegistrationUserToken;
import com.vtii.event.OnRegistrationUserConfirmViaEmailEvent;
import com.vtii.form.AccountFormForCreating;
import com.vtii.form.AccountFormForCreatingRegister;
import com.vtii.form.AccountFormForUpdating;
import com.vtii.repository.IDepartmentRepository;
import com.vtii.repository.IPositionRepository;
import com.vtii.repository.IRegistrationUserTokenRepository;
import com.vtii.specification.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vtii.entity.Account;
import com.vtii.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService{
	@Autowired
	private IAccountRepository accountRepository;
	@Autowired
	private IDepartmentRepository departmentRepository;
	@Autowired
	private IPositionRepository positionRepository;

	@Autowired
	private ApplicationEventPublisher eventPublisher;
	@Autowired
	private IRegistrationUserTokenRepository tokenRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Page<Account> getAllAccount(Pageable pageable, String search) {
		Specification<Account> where = null;
		AccountSpecification nameSpecification = new AccountSpecification("fullname", "LIKE", search);
		AccountSpecification emailSpecification = new AccountSpecification("email", "LIKE", search);
		AccountSpecification departmentSpecification = new AccountSpecification("department.name", "LIKE", search);
		where = Specification.where(nameSpecification).or(emailSpecification).or(departmentSpecification);
		// TODO Auto-generated method stub
		return accountRepository.findAll(where, pageable);
	}

	@Override
	public Account getAccountById(short id) {
		return accountRepository.getById(id);
	}

	@Override
	public void createAccount(AccountFormForCreating form) {
		Account account = new Account();
		Department department = departmentRepository.getById(form.getDepartmentId());
		Position position = positionRepository.getById(form.getPositionId());
		account.setEmail(form.getEmail());
		account.setUsername(form.getUsername());
		account.setFullname(form.getFullname());
		account.setDepartment(department);
		account.setPosition(position);
		accountRepository.save(account);
	}

	@Override
	public void updateAccount(short id, AccountFormForUpdating form) {
		Account account = accountRepository.getById(id);
		account.setFullname(form.getFullname());
		account.setDepartment(departmentRepository.getById(form.getDepartmentId()));
		account.setPosition(positionRepository.getById(form.getPositionId()));
		accountRepository.save(account);
	}

	@Override
	public void deleteAccount(short id) {
		accountRepository.deleteById(id);
	}

	@Override
	public Account getAccountByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = getAccountByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(account.getUsername(), account.getPassword(), AuthorityUtils.createAuthorityList("user"));
	}

	@Override
	public boolean existsByUsername(String name) {
		return accountRepository.existsByUsername(name);
	}

	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return accountRepository.existsByEmail(email);
	}


	@Override
	public void createAccountRegister(AccountFormForCreatingRegister form) {
		Account account = new Account();
		Department department = departmentRepository.getById(form.getDepartmentId());
		Position position = positionRepository.getById(form.getPositionId());
		account.setEmail(form.getEmail());
		account.setUsername(form.getUsername());
		account.setFullname(form.getFullname());
		account.setDepartment(department);
		account.setPosition(position);
		account.setPassword(passwordEncoder.encode(form.getPassword()));
		accountRepository.save(account);

		//create registration token
		createNewRegistrationToken(account);
		sendConfirmUserRegistrationViaEmail(account.getEmail());

	}

	/**
	 * Ham nay de tao token khi dang ky account
	 * */
	private void createNewRegistrationToken(Account account){
		final String newToken = UUID.randomUUID().toString();
		RegistrationUserToken token = new RegistrationUserToken(newToken, account);
		tokenRepository.save(token);
	}

	private void sendConfirmUserRegistrationViaEmail(String email){
		eventPublisher.publishEvent( new OnRegistrationUserConfirmViaEmailEvent(email));
	}

	@Override
	public void activeUser(String token) {
		RegistrationUserToken registrationUserToken = tokenRepository.findByToken(token);
		Account account = registrationUserToken.getAccount();
		account.setStatus(Account.AccountStatus.ACTIVE);
		accountRepository.save(account);
	}

	@Override
	public Account getAccountByEmail(String email) {
		return accountRepository.findByEmail(email);
	}

}
