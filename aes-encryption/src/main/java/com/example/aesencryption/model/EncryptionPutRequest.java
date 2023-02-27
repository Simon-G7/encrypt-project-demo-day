package com.example.aesencryption.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EncryptionPutRequest {

    @Valid
    private EncryptionInput data;

}
