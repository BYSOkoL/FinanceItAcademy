package by.itacademy.classifierservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CurrencyCreateRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;
}