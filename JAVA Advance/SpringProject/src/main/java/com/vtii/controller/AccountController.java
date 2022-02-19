package com.vtii.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.vtii.form.AccountFormForCreating;
import com.vtii.form.AccountFormForUpdating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vtii.dto.AccountDto;
import com.vtii.entity.Account;
import com.vtii.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {
	@Autowired
	private IAccountService accountService;
	
	@GetMapping
	public ResponseEntity<?> getAllAccount(Pageable pageable, @RequestParam(required = false) String search) {
		Page<Account> accounts = accountService.getAllAccount(pageable, search);
		/*List<AccountDto> accountDtos = new ArrayList<>();
		//convert entities to dto
		for(Account account : accounts) {
			AccountDto dto = new AccountDto(account.getId(),account.getEmail(), account.getUsername(),
					account.getFullname(), account.getDepartment().getName(),
					account.getPosition().getPositionName().toString(), account.getCreateDate());
			accountDtos.add(dto);
		}*/
		Page<AccountDto> dtoPage = accounts.map(new Function<Account, AccountDto>() {
			@Override
			public AccountDto apply(Account account) {
				AccountDto dto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(),
						account.getFullname(), account.getDepartment().getName(),
						account.getPosition().getPositionName().toString(), account.getCreateDate());
				return dto;
			}
		});
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable(name = "id") short id){
		Account account = accountService.getAccountById(id);

		AccountDto accountDto = new AccountDto(account.getId(),account.getEmail(), account.getUsername(),
				account.getFullname(), account.getDepartment().getName(),
				account.getPosition().getPositionName().toString(), account.getCreateDate());
		return new ResponseEntity<>(accountDto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> createAccount(@RequestBody AccountFormForCreating form){
		accountService.createAccount(form);
		return new ResponseEntity<String>("Create succesfull", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAccount(@PathVariable(name = "id") short id,@RequestBody AccountFormForUpdating form){
		accountService.updateAccount(id ,form);
		return new ResponseEntity<String>("Update succesfull", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id){
		accountService.deleteAccount(id);
		return new ResponseEntity<String>("Delete succesfull", HttpStatus.OK);
	}

	@GetMapping(value = "/UsernameExists/{name}")
	public ResponseEntity<?> existsByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<>(accountService.existsByUsername(name), HttpStatus.OK);
	}

	@GetMapping(value = "/EmailExists/{email}")
	public ResponseEntity<?> existsByEmail(@PathVariable(name = "email") String email) {
		return new ResponseEntity<>(accountService.existsByEmail(email), HttpStatus.OK);
	}
}
