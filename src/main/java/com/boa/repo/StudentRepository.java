package com.boa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	// Crete / Update // delete / List operation

	// Cutome // JPQL
}
