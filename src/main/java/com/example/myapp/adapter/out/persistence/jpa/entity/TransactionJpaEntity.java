package com.example.myapp.adapter.out.persistence.jpa.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "transactions")
public class TransactionJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long transactionId;
    @Column(name = "amount")
    BigDecimal amount;
    @Column(name = "timestamp")
    Instant timestamp;
    @Column(name = "user_id")
    Long userId;

}
