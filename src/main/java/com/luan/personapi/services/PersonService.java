package com.luan.personapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luan.personapi.dtos.PersonDTO;
import com.luan.personapi.entities.Person;
import com.luan.personapi.exceptions.PersonNotFoundException;
import com.luan.personapi.repositories.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public ResponseEntity<Person> createPerson(PersonDTO personDTO) {
		Person person = new Person(personDTO);
		Person savedPerson = personRepository.save(person);
		return ResponseEntity.ok().body(savedPerson);
	}

	public List<PersonDTO> listAll() {
		List<Person> allPeople = personRepository.findAll();
		List<PersonDTO> allPeopleDTO = allPeople.stream().map(obj -> new PersonDTO(obj)).collect(Collectors.toList());
		return allPeopleDTO;
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isEmpty()) {
			throw new PersonNotFoundException(id);
		}
		return new PersonDTO(optionalPerson.get());
	}

	public void delete(Long id) {
		personRepository.deleteById(id);
	}

	public ResponseEntity<Object> updateById(Long id, PersonDTO personDTO) {
		Optional<Person> personOptional = personRepository.findById(id);
		if (personOptional.isPresent()) {
			var newPerson = new Person(personDTO);
			newPerson.setId(id);
			return ResponseEntity.status(HttpStatus.OK).body(personRepository.save(newPerson));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found with ID: " + id);

	}

}
