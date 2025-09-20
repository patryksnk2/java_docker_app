package com.example.myapp.application.transaction.port.in;

import java.math.BigDecimal;

public record CreateTransactionCommand(BigDecimal amount) {
}
