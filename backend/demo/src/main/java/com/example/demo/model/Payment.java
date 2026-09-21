package com.example.demo.model;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Payment {
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDate paymentDate;
    private String payee;
    private BigDecimal amount;
    private String description;
    private String category;

    // Constructor
    public Payment() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    @NotNull
    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    @NotBlank
    @Size(max = 100)
    public String getPayee() {
        return payee;
    }

    @Positive 
    @NotNull
    @DecimalMax("1000000.00")
    public BigDecimal getAmount() {
        return amount;
    }

    @Size(max = 500)
    public String getDescription() {
        return description;
    }

    @NotBlank
    @Size(max = 100)
    public String getCategory() {
        return category;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
