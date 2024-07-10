package com.boa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boa.entity.Course;
import com.boa.entity.Registration;
import com.boa.entity.Student;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	// Crete / Update // delete / List operation

	// Cutome // JPQL
}
