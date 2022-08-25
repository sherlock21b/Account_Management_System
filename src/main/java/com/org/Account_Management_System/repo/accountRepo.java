package com.org.Account_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.Account_Management_System.dto.bankAccount;


public interface accountRepo extends JpaRepository<bankAccount, Integer>{



}
