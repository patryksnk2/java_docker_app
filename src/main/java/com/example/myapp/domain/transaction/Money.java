package com.example.myapp.domain.transaction;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record Money(@NotNull BigDecimal amount) {
    public Money {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    public Money add(@NotNull BigDecimal amount) {
        return new Money(amount().add(amount));
    }

    public Money substract(@NotNull BigDecimal amount) {
        return new Money(amount().subtract(amount));
    }

}
