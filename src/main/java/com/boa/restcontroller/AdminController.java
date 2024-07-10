package com.boa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.entity.Course;
import com.boa.entity.Professor;
import com.boa.entity.Student;
import com.boa.repo.AdminRepository;
import com.boa.repo.CourseRepository;
import com.boa.repo.ProfessorRepository;
import com.boa.repo.StudentRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping // request mapping change
	public Student generateReportCard(Long id) {
		return studentRepository.findById(id).orElse(null);
	}
	@PostMapping
	public Professor addProfessor(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	@PostMapping
	public void addCourse(@RequestBody Course course) {
		courseRepository.save(course);
//		 studentRepository.findById(id).get().getCourses().add(course);
	}
	@DeleteMapping
	public void deleteCourse(Long id, Long courseId) {
		courseRepository.deleteById(id);;
//		studentRepository.findById(id).get().getCourses().remove(0);
	}
	@PostMapping
	public void approveRegistration(Long id) {
//		return  studentRepository.findById(id).get().getCourses().;
	}

}
//	@GetMapping // request mapping change
//	public List<Student> generateReportCard(@RequestBody Student student ) {
//		return studentRepository.getById(student.getId());
//	}
//
//	@PostMapping
//	public Professor addProfessor(@RequestBody Professor student) {
//		return professorRepository.save(student);
//	}
//
//	@GetMapping("/{id}")
//	public Professor getStudentById(@PathVariable Long id) {
//		return professorRepository.findById(id).orElse(null);
//	}
//
//	@PutMapping("/{id}")
//	public Professor updateStudent(@PathVariable Long id, @RequestBody Professor updatedProfessor) {
//		if (professorRepository.existsById(id)) {
//			updatedProfessor.setId(id);
//			return professorRepository.save(updatedProfessor);
//		}
//		return null;
//	}
//
//	@DeleteMapping("/{id}")
//	public void deleteStudent(@PathVariable Long id) {
//		professorRepository.deleteById(id);
//	}
