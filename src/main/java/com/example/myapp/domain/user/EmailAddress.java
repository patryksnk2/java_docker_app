package com.example.myapp.domain.user;

import jakarta.validation.constraints.NotNull;
import lombok.Value;


public record EmailAddress(@NotNull String value) {
    public EmailAddress{
        if(!value.matches("^[^@]+@[^@]+\\.[^@]+$")){
            throw new IllegalArgumentException("Invalid email address");
        }
    }
}
