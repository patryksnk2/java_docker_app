package com.example.myapp.domain.transaction;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.Instant;


public class Transaction {

    @Getter
    private Money amount;

    private Instant timestamp;

    public static Transaction create(@NotNull Money amount) {
        Transaction transaction = new Transaction();
        transaction.amount = amount;
        transaction.timestamp = Instant.now();
        return transaction;
    }

}
