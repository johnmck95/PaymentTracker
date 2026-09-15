package com.example.demo.controller;
import com.example.demo.model.Payment;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PaymentService;

@RestController 
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping 
    public List<Payment> getPayments(){
        return paymentService.getAllPayments();
    }

    @PostMapping 
    public Payment createPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id){
        paymentService.deletePayment(id);
    }

}
