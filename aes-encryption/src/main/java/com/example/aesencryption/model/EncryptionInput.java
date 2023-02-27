package com.example.aesencryption.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class EncryptionInput {

    @NotBlank
    private String value1;

    @NotNull
    @Min(value = 0,message = "Valor minimo cero")
    private Integer value2;

    @NotBlank
    private String value3;

}
