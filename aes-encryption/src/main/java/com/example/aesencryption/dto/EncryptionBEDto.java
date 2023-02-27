package com.example.aesencryption.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EncryptionBEDto {

    private long id_table;

    private String valor1;

    private Integer valor2;

    private byte[] valor3;
}
