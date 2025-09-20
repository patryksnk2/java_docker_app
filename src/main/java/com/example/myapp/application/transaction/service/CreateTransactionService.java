package com.example.myapp.application.transaction.service;

import com.example.myapp.application.transaction.port.in.CreateTransactionCommand;
import com.example.myapp.application.transaction.port.in.TransactionResponse;
import com.example.myapp.application.transaction.port.in.TransactionUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionService implements TransactionUseCase {

    public TransactionResponse create(CreateTransactionCommand command) {
        return null;
    }
}
