package com.boa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.entity.Course;
import com.boa.entity.Professor;
import com.boa.repo.AdminRepository;
import com.boa.repo.CourseRepository;
import com.boa.repo.ProfessorRepository;
import com.boa.repo.RegistrationRepository;
import com.boa.repo.StudentRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private RegistrationRepository registrationRepository;

	public String addCourse(Course course) {

				courseRepository.save(course);
				return "course added";
	}
	public String addProfessor(Professor professor) {

		professorRepository.save(professor);
		return "professor added";
	}
	public String deleteCourse(Long id) {
		courseRepository.deleteById(id);;
		return "course deleted";
	}
	public String approveStudent(Long studentId) {
		registrationRepository.getById(studentId).setStatus("Registered");;
		return "Student registered";
	}
}
