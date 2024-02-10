package com.example.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OrderService.model.Order;
import com.example.OrderService.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(nativeQuery = true, value = "select * from usertbl where user_id =:userId")
	Object IsUserExistByUserId(@Param("userId") String userId);
	
	@Query(nativeQuery = true, value = "select * from usertbl where user_id =:userId")
	User getUserByUserId(@Param("userId") String userId);

}
