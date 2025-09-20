package com.example.myapp.application.user.port.in;

public record UserResponse(Long userId,String name,String email,String password) {
}
