package com.example.aesencryption;

import com.example.aesencryption.model.EncryptionInput;
import com.example.aesencryption.model.EncryptionPostRequest;
import com.example.aesencryption.model.EncryptionPutRequest;
import com.example.aesencryption.repository.entity.EncryptionBE;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataTest {

    public List<EncryptionBE> encryptionBEList (){

        EncryptionBE item1 = new EncryptionBE(1,"value1",1323,"valor1".getBytes(StandardCharsets.UTF_8));
        EncryptionBE item2 = new EncryptionBE(2,"value2",3432,"valor2".getBytes(StandardCharsets.UTF_8));
        EncryptionBE item3 = new EncryptionBE(3,"value3",4856,"valor3".getBytes(StandardCharsets.UTF_8));
        EncryptionBE item4 = new EncryptionBE(4,"value4",2380,"valor4".getBytes(StandardCharsets.UTF_8));

        List<EncryptionBE> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);

        return  list;
    }

    public Optional<EncryptionBE> encryptionItem (){

        EncryptionBE item = new EncryptionBE(1,"value1",1323,"valor1".getBytes(StandardCharsets.UTF_8));

        return  Optional.of(item);
    }

    public EncryptionPostRequest encryptionPostItem (){

        EncryptionInput data = new EncryptionInput("value1",1323,"valor1");

        EncryptionPostRequest item = new EncryptionPostRequest();
        item.setData(data);
        return  item;
    }

    public EncryptionPutRequest encryptionPutItem (){

        EncryptionInput data = new EncryptionInput("value1",1323,"valor1");

        EncryptionPutRequest item = new EncryptionPutRequest();
        item.setData(data);
        return  item;
    }
}
