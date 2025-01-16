package com.tekarch.accountms.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(name = "account_number", nullable = false, unique = true, length = 20)
    private String accountNumber;// VARCHAR(20) UNIQUE, NOT NULL
    @Column(name = "account_type", nullable = false,length = 20)
    private String accountType;
    @Column(name = "currency",length = 10, columnDefinition = "VARCHAR(10) DEFAULT 'USD'")
    private String currency; // VARCHAR(10) with default value 'USD'
    @Column(name = "balance",columnDefinition = "DECIMAL(15,2) DEFAULT 0.0")
    private Double balance; // DECIMAL(15,2) with default value 0.0
    @Column(name = "created_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;



    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist()
    {
        this.createdAt= LocalDateTime.now();
    }
}
