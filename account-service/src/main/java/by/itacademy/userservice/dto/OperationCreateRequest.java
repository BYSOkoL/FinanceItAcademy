package by.itacademy.userservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class OperationCreateRequest {

    @NotNull
    private long date;

    @NotBlank
    private String description;

    @NotNull
    private String category;

    @NotNull
    private double value;

    @NotNull
    private String currency;
}