package com.boa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.entity.Course;
import com.boa.entity.Grade;
import com.boa.entity.Student;
import com.boa.repo.GradeRepository;
import com.boa.repo.ProfessorRepository;
import com.boa.repo.StudentRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private GradeRepository gradeRepository;


	public String addGrades(Long id, String grade) {
		studentRepository.getById(id).setGrade(grade);
	
				return "grade added";
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
}

}
