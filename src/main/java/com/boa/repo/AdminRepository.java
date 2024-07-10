package com.boa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boa.entity.Admin;
import com.boa.entity.User;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	// Crete / Update // delete / List operation

	// Cutome // JPQL
	/**
	 * @return
	 * Query use to fetch unapproved user.
	 */
	@Query(value="Select * from user where isApproved=0",nativeQuery=true)
	List<User> findUnapproved();
	
}
