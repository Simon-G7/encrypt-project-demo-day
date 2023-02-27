package com.example.aesencryption.mapper;

import com.example.aesencryption.dto.EncryptionBEDto;
import com.example.aesencryption.repository.entity.EncryptionBE;
import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T13:34:46-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class IEncryptionBEMapperImpl implements IEncryptionBEMapper {

    @Override
    public EncryptionBEDto encryptionBE_to_encryptionDTO(EncryptionBE encryption_entity) {
        if ( encryption_entity == null ) {
            return null;
        }

        EncryptionBEDto encryptionBEDto = new EncryptionBEDto();

        encryptionBEDto.setId_table( encryption_entity.getId_table() );
        encryptionBEDto.setValor1( encryption_entity.getValor1() );
        encryptionBEDto.setValor2( encryption_entity.getValor2() );
        byte[] valor3 = encryption_entity.getValor3();
        if ( valor3 != null ) {
            encryptionBEDto.setValor3( Arrays.copyOf( valor3, valor3.length ) );
        }

        return encryptionBEDto;
    }
}
