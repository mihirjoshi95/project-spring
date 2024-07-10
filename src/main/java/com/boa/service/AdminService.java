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
import com.boa.repo.UserRepository;

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

	@Autowired
	private UserRepository userRepository;

	public void addCourse(Course course) {

				courseRepository.save(course);
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
		userRepository.findUnapproved().forEach(x->{
			if(x.getUserId()==studentId) {
				x.setIsApproved(1);
			}
		}
		);
//		registrationRepository.getById(studentId).setStatus("Registered");;
		return "Student registered";
	}
}
