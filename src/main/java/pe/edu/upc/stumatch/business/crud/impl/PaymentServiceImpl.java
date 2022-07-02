package pe.edu.upc.stumatch.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.stumatch.business.crud.PaymentService;
import pe.edu.upc.stumatch.model.entity.Payment;
import pe.edu.upc.stumatch.model.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public JpaRepository<Payment, Integer> getJpaRepository() {
		return this.paymentRepository;
	}
}
