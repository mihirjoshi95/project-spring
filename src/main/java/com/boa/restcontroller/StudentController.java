package com.boa.restcontroller;

import com.boa.entity.Course;
import com.boa.entity.Grade;
import com.boa.entity.Student;
import com.boa.repo.CourseRepository;
import com.boa.repo.GradeRepository;
import com.boa.repo.PaymentRepository;
import com.boa.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@PostMapping
	public String registerCourse(@RequestBody Course course, Long id) {
		//TODO: process POST request
		studentRepository.getById(id).getCourses().add(course);
		return "success";
	}

	@GetMapping
	public Grade ViewGrades(@PathVariable Long id) {
		// role check needed with SID
		return gradeRepository.getById(id);
	}

	@PostMapping
	public Course addCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}

	@DeleteMapping
	public String deleteCourse(@PathVariable Long studenID) {
		try {
			Student student = studentRepository.getById(studenID);
			gradeRepository.deleteById(student.getId());
			return "SUCCESS";
		} catch (Exception ex) {
			ex.getCause();
		}
		return HttpStatus.BAD_REQUEST.getReasonPhrase();
	}

}
