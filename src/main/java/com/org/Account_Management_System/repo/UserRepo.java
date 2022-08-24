package com.org.Account_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.org.Account_Management_System.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{


}
