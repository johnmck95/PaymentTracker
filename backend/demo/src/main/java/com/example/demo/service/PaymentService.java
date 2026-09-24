package com.example.demo.service;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAllByOrderByPaymentDateDesc();
    }

    public Payment addPayment(Payment payment) {
        LocalDateTime now = LocalDateTime.now();

        payment.setCreatedDate(now);
        payment.setUpdatedDate(now);

        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}