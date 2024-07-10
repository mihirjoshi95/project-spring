package com.boa.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.entity.Student;
import com.boa.repo.PaymentRepository;


@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@GetMapping // request mapping change
	public Integer makePayment(Long id,int amount) {
		int balance = paymentRepository.getById(id).getAmount() - amount;
		return balance;
	}
}
