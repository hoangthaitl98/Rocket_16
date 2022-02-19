package com.vtii.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtii.entity.Account;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IAccountRepository extends JpaRepository<Account, Short>, JpaSpecificationExecutor<Account> {
    public Account findByUsername(String username);

    public Account findByEmail(String email);

    public boolean existsByUsername(String name);
    public boolean existsByEmail(String email);

}
