package by.itacademy.classifierservice.security;

import lombok.Data;

@Data
public class UserResponse {
    private String mail;
    private String password;
    private String role;
}