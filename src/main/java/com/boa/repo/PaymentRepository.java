package com.boa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boa.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	// Crete / Update // delete / List operation

	// Cutome // JPQL
}
