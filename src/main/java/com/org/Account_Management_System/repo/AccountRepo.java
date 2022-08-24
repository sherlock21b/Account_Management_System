package com.org.Account_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.Account_Management_System.dto.BankAccount;


public interface AccountRepo extends JpaRepository<BankAccount, Integer>{



}
