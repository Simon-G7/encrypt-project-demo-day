package com.example.aesencryption.service;

import com.example.aesencryption.model.*;
import org.springframework.http.ResponseEntity;

public interface IEncryptionService {

    ResponseEntity<EncryptionGetAllResponse> getAllEncryptionServiceHandler();

    ResponseEntity<EncryptionGetRs> getEncryptionServiceHandler(String id_key, String header);

    ResponseEntity<EncryptionPostResponse> postEncryptionServiceHandler(EncryptionPostRequest body, String password);

    ResponseEntity<EncryptionDeleteResponse> deleteEncryptionServiceHandler(String id_key);

    ResponseEntity<EncryptionPutResponse> putEncryptionServiceHandler(String id_key, EncryptionPutRequest body, String password);


}
