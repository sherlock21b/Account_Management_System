package com.org.Account_Management_System.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.Account_Management_System.dto.User;

import java.util.List;

public interface userRepo extends JpaRepository<User, Integer>{
	@Query( value="select * from ams.user b where b.user_id=?",nativeQuery = true )
	User findByUserId(int user_id);
	
	@Query( value="select b.name from ams.customer b where b.customer_id=?",nativeQuery = true )
	String getCustomerNameById(int customer_id);
	
	@Query( value="select * from ams.bank_account b where b.customer_id=?",nativeQuery = true )
	List<Object[]> getAccountDetailsById(int customer_id);

}
