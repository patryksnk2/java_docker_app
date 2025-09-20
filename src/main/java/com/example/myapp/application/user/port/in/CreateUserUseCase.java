package com.example.myapp.application.user.port.in;

public interface CreateUserUseCase {
    UserResponse create(CreateUserCommand command);
}
