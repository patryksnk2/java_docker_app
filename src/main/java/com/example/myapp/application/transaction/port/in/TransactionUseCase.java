package com.example.myapp.application.transaction.port.in;

public interface TransactionUseCase {
    TransactionResponse create(CreateTransactionCommand command);
}
