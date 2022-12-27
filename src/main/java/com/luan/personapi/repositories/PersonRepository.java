package com.luan.personapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luan.personapi.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
