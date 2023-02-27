package com.projet.maktub.services;

import java.util.List;
import java.util.Optional;

import com.projet.maktub.dto.PersonDto;
import com.projet.maktub.model.Person;




public interface PersonService {
	/*
	String signin(String email, String password);
	String signup(Person user);
	*/
	PersonDto save(PersonDto dto);
	
	boolean addFriendToUser(Person person , Person friend);

	
	boolean saveUser(Person utilisateur);

	PersonDto findById(Integer id);

	List<PersonDto> findAll();
	
	Optional<Person> findByEmail(String email);


    void delete(Integer id);


}
