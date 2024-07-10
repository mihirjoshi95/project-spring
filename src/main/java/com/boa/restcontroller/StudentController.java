package com.boa.restcontroller;

import com.boa.entity.Course;
import com.boa.entity.Grade;
import com.boa.entity.Payment;
import com.boa.entity.Student;
import com.boa.repo.CourseRepository;
import com.boa.repo.GradeRepository;
import com.boa.repo.PaymentRepository;
import com.boa.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

	@PostMapping
	public void  payCourseFee(@RequestBody Student student) {
     Integer studentTotalFeeAmount = 0;
		Student studentData = studentRepository.findById(student.getId()).orElse(null);
		if(null != studentData){
			List<Course> courses = studentData.getCourses();
			courses.stream().forEach(elt ->{
				Course course = courseRepository.findById(elt.getId()).orElse(null);

			});
		}
		if(studentTotalFeeAmount > 0){
			Payment payment = new Payment();
			payment.setAmount(studentTotalFeeAmount);
			payment.setType("ONLINE");
			paymentRepository.save(payment);
		}
	}

}
