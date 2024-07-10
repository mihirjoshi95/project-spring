package com.boa.restcontroller;

import com.boa.entity.Course;
import com.boa.entity.Payment;
import com.boa.entity.Student;
import com.boa.repo.CourseRepository;
import com.boa.repo.PaymentRepository;
import com.boa.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/paymenyFee")
public class PaymentController {
	
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

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
