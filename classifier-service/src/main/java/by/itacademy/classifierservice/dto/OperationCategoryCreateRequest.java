package by.itacademy.classifierservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OperationCategoryCreateRequest {

    @NotBlank
    private String title;
}