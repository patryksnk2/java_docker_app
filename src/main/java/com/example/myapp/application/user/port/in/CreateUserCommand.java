package com.example.myapp.application.user.port.in;

public record CreateUserCommand(String name, String email, String password) {
}
