package com.luan.personapi.dtos;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luan.personapi.entities.Person;
import com.luan.personapi.entities.Phone;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PersonDTO {

	private Long id;

	@NotEmpty
	@Size(min = 2, max = 100)
	private String firstName;

	@NotEmpty
	@Size(min = 2, max = 100)
	private String lastName;

	@CPF
	@NotEmpty
	private String cpf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;

	@NotEmpty
	@Valid
	private List<Phone> phones;

	public PersonDTO(Long id, String firstName, String lastName, String cpf, LocalDate birthDate, List<Phone> phones) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.phones = phones;
	}

	public PersonDTO() {
		super();
	}

	public PersonDTO(Person obj) {
		super();
		this.id = obj.getId();
		this.firstName = obj.getFirstName();
		this.lastName = obj.getLastName();
		this.cpf = obj.getCpf();
		this.birthDate = obj.getBirthDate();
		this.phones = obj.getPhones();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
