package com.luan.personapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.luan.personapi.dtos.PersonDTO;
import com.luan.personapi.entities.Person;
import com.luan.personapi.exceptions.PersonNotFoundException;
import com.luan.personapi.services.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Person> createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}

	@GetMapping
	public List<PersonDTO> listAll() {
		return personService.listAll();
	}

	@GetMapping("/{id}")
	public PersonDTO findByID(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		personService.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
		return personService.updateById(id, personDTO);
	}

}
