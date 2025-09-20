package com.example.myapp.application.transaction.port.in;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record TransactionResponse(Long transactionId, Long userId, BigDecimal amount, Timestamp timestamp) {
}
