package com.example.myapp.domain.user;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class User {

    @Getter
    String name;
    @Getter
    EmailAddress email;

    String password;

    public static User create(@NotNull String name, EmailAddress email, String password) {
        User user = new User();
        user.email = email;
        user.name = name;
        user.password = password;
        return user;
    }

    public void changeEmail(EmailAddress newEmail) {
        this.email = newEmail;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void changePassword(String newRawPassword) {
        if (newRawPassword.length() < 6) {
            throw new IllegalArgumentException("Password too short");
        }
        this.password = newRawPassword;
    }
}