package com.luan.personapi.dtos;

import com.luan.personapi.enums.PhoneType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PhoneDTO {

	private Long id;

	@Enumerated(EnumType.STRING)
	private PhoneType type;

	@NotEmpty
	@Size(min = 13, max = 14)
	private String number;

	public PhoneDTO(Long id, PhoneType type, String number) {
		super();
		this.id = id;
		this.type = type;
		this.number = number;
	}

	public PhoneDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
