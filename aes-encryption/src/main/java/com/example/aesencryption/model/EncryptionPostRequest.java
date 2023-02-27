package com.example.aesencryption.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EncryptionPostRequest {

    @Valid
    private EncryptionInput data;

}
