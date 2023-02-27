package com.example.aesencryption.service;

import com.example.aesencryption.dto.EncryptionBEDto;
import com.example.aesencryption.mapper.IEncryptionBEMapper;
import com.example.aesencryption.model.*;
import com.example.aesencryption.repository.IEncryptionRepository;
import com.example.aesencryption.repository.entity.EncryptionBE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EncryptionService implements IEncryptionService{

    private IEncryptionBEMapper mapper;

    private IEncryptionRepository encryptionRepository;

    @Autowired
    public EncryptionService(IEncryptionBEMapper mapper, IEncryptionRepository encryptionRepository) {
        this.mapper = mapper;
        this.encryptionRepository = encryptionRepository;
    }

    @Override
    public ResponseEntity<EncryptionGetAllResponse> getAllEncryptionServiceHandler() {

        log.info("entrando a metodo para obtener todos en Service");
        EncryptionGetAllResponse encryption_response = new EncryptionGetAllResponse();
        List<EncryptionBE> encryptionRepositoryList = encryptionRepository.findAll();

        List<EncryptionBEDto> encryptionModelList = encryptionRepositoryList.stream().map(mapper::encryptionBE_to_encryptionDTO).toList();

        encryption_response.setInformation_list(encryptionModelList);

       return ResponseEntity.status(HttpStatus.OK).body(encryption_response);
    }

    @Override
    public ResponseEntity<EncryptionGetRs> getEncryptionServiceHandler(String id_key, String header){

        EncryptionBE encryptionData= encryptionRepository.find_data_by_key(id_key,header).get();

        EncryptionGetRs getResponse= new EncryptionGetRs();

        getResponse.setId_table(encryptionData.getId_table());
        getResponse.setValue1(encryptionData.getValor1());
        getResponse.setValue2(encryptionData.getValor2());
        getResponse.setValue3(new String(encryptionData.getValor3()));

        return ResponseEntity.status(HttpStatus.OK).body(getResponse);

    }



    @Override
    public ResponseEntity<EncryptionPostResponse> postEncryptionServiceHandler(EncryptionPostRequest body, String password) {

        log.info("entrando a metodo para guardar registro. Clase Service");

        EncryptionPostResponse encryptionResponse = new EncryptionPostResponse();
        int row= encryptionRepository.save_data( body.getData().getValue1(), body.getData().getValue2(), body.getData().getValue3(), password);
        encryptionResponse.setCode("400");
        encryptionResponse.setResponse("Failure");
        if (row>0) {
            encryptionResponse.setCode("200");
            encryptionResponse.setResponse("Inserted");
        }

        return ResponseEntity.status(HttpStatus.OK).body(encryptionResponse);

    }

    @Override
    public ResponseEntity<EncryptionDeleteResponse> deleteEncryptionServiceHandler(String id_key) {

        log.info("entrando a metodo para eliminar registro. Clase Service");

        EncryptionDeleteResponse encryptionResponse = new EncryptionDeleteResponse();
        int row= encryptionRepository.delete_data(id_key);
        encryptionResponse.setCode("400");
        encryptionResponse.setResponse("Failure");
        if (row>0) {
            encryptionResponse.setCode("200");
            encryptionResponse.setResponse("Deleted");
        }

        return ResponseEntity.status(HttpStatus.OK).body(encryptionResponse);

    }

    @Override
    public ResponseEntity<EncryptionPutResponse> putEncryptionServiceHandler(String id_key, EncryptionPutRequest body, String password) {

        log.info("entrando a metodo para actualizar registro. Clase Service");

        EncryptionPutResponse encryption_response = new EncryptionPutResponse();
        int row= encryptionRepository.update_data(id_key, body.getData().getValue1(), body.getData().getValue2(), body.getData().getValue3(), password);
        encryption_response.setCode("400");
        encryption_response.setResponse("Failure");
        if (row>0) {
            encryption_response.setCode("200");
            encryption_response.setResponse("Modified");
        }

        return ResponseEntity.status(HttpStatus.OK).body(encryption_response);

    }
}
