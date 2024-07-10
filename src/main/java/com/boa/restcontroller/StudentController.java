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
import com.boa.entity.Student;
import com.boa.repo.GradeRepository;
import com.boa.repo.StudentRepository;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private GradeRepository gradeRepository;

	@PostMapping
	public String registerCourse(@RequestBody Course course, Long id) {
		//TODO: process POST request
		studentRepository.getById(id).getCourses().add(course);
		return "success";
	}
	
	@GetMapping
	public String ViewGrades(@RequestBody Long id) {
		return gradeRepository.getById(id).getGrade();
	}
	
	public String addCourse(@RequestBody Course course, Long id) {
		//TODO: process POST request
		studentRepository.getById(id).getCourses().add(course);
		return "success";
	}
	public String deleteGrade(@RequestBody Long id) {
		//TODO: process POST request
		gradeRepository.deleteById(id);;
		return "success";
	}
//	 // request mapping change
//	public List<Student> getAllStudents() {
//		return studentRepository.findAll();
//	}
//
//	@GetMapping // request mapping change
//	public List<Student> getAllStudents() {
//		return studentRepository.findAll();
//	}
//
//	@PostMapping
//	public Student addStudent(@RequestBody Student student) {
//		return studentRepository.save(student);
//	}
//
//	@GetMapping("/{id}")
//	public Student getStudentById(@PathVariable Long id) {
//		return studentRepository.findById(id).orElse(null);
//	}
//
//	@PutMapping("/{id}")
//	public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
//		if (studentRepository.existsById(id)) {
//			updatedStudent.setId(id);
//			return studentRepository.save(updatedStudent);
//		}
//		return null;
//	}
//
//	@DeleteMapping("/{id}")
//	public void deleteStudent(@PathVariable Long id) {
//		studentRepository.deleteById(id);
//	}

}
