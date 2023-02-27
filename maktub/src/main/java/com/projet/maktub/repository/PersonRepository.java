package com.projet.maktub.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.maktub.model.Person;


public interface PersonRepository extends JpaRepository<Person, Integer> {
	
    /*Optional<Person> findByNom(@Param("nom") String nom);*/
	List<Person> findByNom(String nom);
	Optional<Person> findByMail(String mail);
	boolean existsByMail(String email);

}