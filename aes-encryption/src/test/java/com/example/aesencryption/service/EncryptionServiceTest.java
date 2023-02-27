package com.example.aesencryption.service;

import com.example.aesencryption.DataTest;
import com.example.aesencryption.mapper.IEncryptionBEMapper;
import com.example.aesencryption.model.*;
import com.example.aesencryption.repository.IEncryptionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EncryptionServiceTest {

    @Mock
    private IEncryptionBEMapper mapper;

    @Mock
    private IEncryptionRepository encryptionRepository;

    @InjectMocks
    private EncryptionService encryptionService;

    DataTest data = new DataTest();

    @Test
    void successWhenGetAllEncryptionServiceHandler(){

        when(encryptionRepository.findAll()).thenReturn(data.encryptionBEList());

        ResponseEntity<EncryptionGetAllResponse> res= encryptionService.getAllEncryptionServiceHandler();

        assertNotNull(res);
        assertEquals(4,res.getBody().getInformation_list().size());

    }

    @Test
    void successWhenGetEncryptionServiceHandler(){

        when(encryptionRepository.find_data_by_key("1","pass")).thenReturn(data.encryptionItem());

        ResponseEntity<EncryptionGetRs> res= encryptionService.getEncryptionServiceHandler("1","pass");

        assertNotNull(res);
        assertEquals(1323,res.getBody().getValue2());

    }

    @Test
    void successWhenPostEncryptionServiceHandler(){

        EncryptionPostRequest input =data.encryptionPostItem();
        when(encryptionRepository.save_data(input.getData().getValue1(),input.getData().getValue2(),input.getData().getValue3(), "pass")).thenReturn(1);

        ResponseEntity<EncryptionPostResponse> res= encryptionService.postEncryptionServiceHandler(input,"pass");

        assertNotNull(res);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals("200",res.getBody().getCode());

    }

    @Test
    void failWhenPostEncryptionServiceHandler(){

        EncryptionPostRequest input =data.encryptionPostItem();
        when(encryptionRepository.save_data(input.getData().getValue1(),input.getData().getValue2(),input.getData().getValue3(), "pass")).thenReturn(0);

        ResponseEntity<EncryptionPostResponse> res= encryptionService.postEncryptionServiceHandler(input,"pass");

        assertNotNull(res);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals("400",res.getBody().getCode());

    }

    @Test
    void successWhenDeleteEncryptionServiceHandler(){

        when(encryptionRepository.delete_data("1")).thenReturn(1);

        ResponseEntity<EncryptionDeleteResponse> res= encryptionService.deleteEncryptionServiceHandler("1");

        assertNotNull(res);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals("200",res.getBody().getCode());

    }

    @Test
    void failWhenDeleteEncryptionServiceHandler(){

        when(encryptionRepository.delete_data("1")).thenReturn(0);

        ResponseEntity<EncryptionDeleteResponse> res= encryptionService.deleteEncryptionServiceHandler("1");

        assertNotNull(res);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals("400",res.getBody().getCode());

    }

    @Test
    void successWhenPutEncryptionServiceHandler(){

        EncryptionPutRequest input =data.encryptionPutItem();
        when(encryptionRepository.update_data("1",input.getData().getValue1(),input.getData().getValue2(),input.getData().getValue3(), "pass")).thenReturn(1);

        ResponseEntity<EncryptionPutResponse> res= encryptionService.putEncryptionServiceHandler("1",input,"pass");

        assertNotNull(res);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals("200",res.getBody().getCode());

    }

    @Test
    void failWhenPutEncryptionServiceHandler(){

        EncryptionPutRequest input =data.encryptionPutItem();
        when(encryptionRepository.update_data("1",input.getData().getValue1(),input.getData().getValue2(),input.getData().getValue3(), "pass")).thenReturn(0);

        ResponseEntity<EncryptionPutResponse> res= encryptionService.putEncryptionServiceHandler("1",input,"pass");

        assertNotNull(res);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals("400",res.getBody().getCode());

    }

}