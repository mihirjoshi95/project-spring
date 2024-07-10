package com.boa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boa.entity.Course;
import com.boa.entity.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	// Crete / Update // delete / List operation

	// Cutome // JPQL
}
