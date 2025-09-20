package com.example.myapp.application.user.port.out;

public interface LoadUserPort {
    Optional<User> findById;
    Optional<User> findByEmail;
}
