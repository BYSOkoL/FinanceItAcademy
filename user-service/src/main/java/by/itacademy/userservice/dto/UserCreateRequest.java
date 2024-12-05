package by.itacademy.userservice.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserCreateRequest {

    @Email
    @NotBlank
    private String mail;

    @NotBlank
    private String fio;

    @NotBlank
    private String password;

    @NotBlank
    private String role;

    @NotBlank
    private String status;
}