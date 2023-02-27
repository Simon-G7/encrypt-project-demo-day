package com.example.aesencryption.controller;

import com.example.aesencryption.model.*;
import com.example.aesencryption.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/encryption")
@CrossOrigin(origins = "*")
public class EncryptionController {
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    @Autowired
    EncryptionService encryptionService;

    @GetMapping
    public ResponseEntity<EncryptionGetAllResponse> encryptionGetAll() {
        return encryptionService.getAllEncryptionServiceHandler();
    }

    @GetMapping(value = "/{id_key}")
    public ResponseEntity<EncryptionGetRs> encryptionGetById(@PathVariable String id_key, @RequestHeader(value = "password", required = true) String pass) {
        return encryptionService.getEncryptionServiceHandler(id_key, pass);
    }

    @PostMapping
    public ResponseEntity<EncryptionPostResponse> encryptionPost(@RequestBody @Validated EncryptionPostRequest encryptionPostRequest, @RequestHeader(value = "password", required = true) String pass) {
        return encryptionService.postEncryptionServiceHandler(encryptionPostRequest, pass);
    }

    @PutMapping(value = "/{id_key}")
    public ResponseEntity<EncryptionPutResponse> encryptionPut(@PathVariable String id_key, @RequestBody @Validated EncryptionPutRequest encryptionPutRequest, @RequestHeader(value = "password", required = true) String pass) {
        return encryptionService.putEncryptionServiceHandler(id_key, encryptionPutRequest, pass);
    }

    @DeleteMapping(value = "/{id_key}")
    public ResponseEntity<EncryptionDeleteResponse> encryptionDelete(@PathVariable String id_key) {
        return encryptionService.deleteEncryptionServiceHandler(id_key);
    }

}
