package by.itacademy.userservice.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserLoginRequest {

    @Email
    @NotBlank
    private String mail;

    @NotBlank
    private String password;
}