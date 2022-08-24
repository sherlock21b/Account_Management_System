package com.org.Account_Management_System.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.org.Account_Management_System.dto.account_transaction;

public interface AMSRepo extends JpaRepository<account_transaction,Integer> {
	  
}


/*

package com.org.springbootuser.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.springbootuser.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

		List<User> getByName(String name);
		List<User> getByEmail(String mail);

		
	 @Query("Select u from User u where u.email= ?1 and u.password=?2")
	 List<User> validateUser(String email,String password);
}


*/