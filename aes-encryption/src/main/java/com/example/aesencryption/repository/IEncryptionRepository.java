package com.example.aesencryption.repository;

import com.example.aesencryption.repository.entity.EncryptionBE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEncryptionRepository extends JpaRepository<EncryptionBE, Long> {

    @Transactional(readOnly=true)
    List<EncryptionBE> findAll();

    @Transactional(readOnly=true)
    @Query(value = "SELECT id_table,valor1,valor2,CAST(AES_DECRYPT(valor3,?2) AS char) AS valor3 FROM prueba_cifrado_tabla where id_table = ?1", nativeQuery = true)
    public Optional<EncryptionBE> find_data_by_key(String id_key, String password);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO  prueba_cifrado_tabla (valor1, valor2, valor3) VALUES (?1, ?2,aes_encrypt(?3,?4))", nativeQuery = true)
    public int save_data(String v1, Integer v2, String v3, String password);

    @Transactional
    @Modifying
    @Query(value = "UPDATE prueba_cifrado_tabla SET valor1= ?2, valor2= ?3, valor3=aes_encrypt(?4, ?5) WHERE id_table=?1", nativeQuery = true)
    public int update_data(String id_key, String v1, Integer v2, String v3, String password);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM prueba_cifrado_tabla WHERE id_table=?1", nativeQuery = true)
    public int delete_data(String id_key);

}
