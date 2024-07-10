package com.boa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boa.entity.Grade;
import com.boa.entity.Student;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
	// Crete / Update // delete / List operation

	// Cutome // JPQL
}
