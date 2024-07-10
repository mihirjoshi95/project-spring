package com.boa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boa.entity.Grade;
import com.boa.entity.Student;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
	// Crete / Update // delete / List operation
	@Query(value = "select * from grade where id =?", nativeQuery = true)
	List<Grade> findById(int studentId);
	// Cutome // JPQL
}
