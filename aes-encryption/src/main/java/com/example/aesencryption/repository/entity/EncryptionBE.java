package com.example.aesencryption.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prueba_cifrado_tabla")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class EncryptionBE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_table;

    @Column
    private String valor1;

    @Column
    private Integer valor2;

    private byte[] valor3;


}
