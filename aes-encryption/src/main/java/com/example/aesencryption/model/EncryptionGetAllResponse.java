package com.example.aesencryption.model;

import com.example.aesencryption.dto.EncryptionBEDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class EncryptionGetAllResponse {

	private List<EncryptionBEDto> information_list;
}
