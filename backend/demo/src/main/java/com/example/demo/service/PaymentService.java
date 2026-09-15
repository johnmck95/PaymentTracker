package com.example.demo.service;

import com.example.demo.model.Payment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final List<Payment> payments = new ArrayList<>();
    private Long nextId = 1L;

    public List<Payment> getAllPayments() {
        return payments;
    }

    public Payment addPayment(Payment payment){
        payment.setId(nextId++);

        LocalDateTime now = LocalDateTime.now();
        payment.setCreatedDate(now);
        payment.setUpdatedDate(now);

        payments.add(payment);
        return payment;
    }

    public void deletePayment(Long id){
        payments.removeIf(payment -> payment.getId().equals(id));
    }
}
