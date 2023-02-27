package com.projet.maktub.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
/*
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
*/
import org.springframework.stereotype.Service;

import com.projet.maktub.dto.PersonDto;
import com.projet.maktub.exception.CustomException;
import com.projet.maktub.model.Links;
import com.projet.maktub.model.Person;
import com.projet.maktub.model.Role;
import com.projet.maktub.repository.OrderClientRepository;
import com.projet.maktub.repository.PersonRepository;
/*
import com.projet.maktub.security.JwtTokenProvider;
*/
import com.projet.maktub.services.PersonService;



@Service
public class PersonServiceImpl implements PersonService {

  private PersonRepository personRepository;
  private OrderClientRepository orderClientRepository;

  @Autowired
  public PersonServiceImpl(PersonRepository personRepository, OrderClientRepository orderClientRepository) {
    this.personRepository = personRepository;
    this.orderClientRepository = orderClientRepository;
  }
  
  /*
	 @Autowired
	  private PasswordEncoder passwordEncoder;

	  @Autowired
	  private JwtTokenProvider jwtTokenProvider;

	  @Autowired
	  private AuthenticationManager authenticationManager;

	  public String signin(String email, String password) {
	    try {
	      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
	      return jwtTokenProvider.createToken(email, personRepository.findByMail(email).get().getRoles());
	    } catch (AuthenticationException e) {
	      throw new CustomException("Invalid username/password supplied",HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	  }

	  public String signup(Person user) {
	    if (!personRepository.existsByMail(user.getMail())) {
	      user.setPassword(passwordEncoder.encode(user.getPassword()));
	      user.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));

	      personRepository.save(user);
	      return jwtTokenProvider.createToken(user.getMail(), user.getRoles());
	    } else {
	      throw new CustomException("email is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	  }
  */
  
  

	
	@Override
	public boolean addFriendToUser(Person person,  Person friend) {
		Person persond;
		Person friendd;
		persond =  this.personRepository.findByMail(person.getMail()).get();
		friendd = this.personRepository.findByMail(friend.getMail()).get();
		 if(persond!=null) {
				if(persond.getFriends().add(friendd)) {
					this.personRepository.save(persond);
					return true;
				}
				}
				return false;
	}

	

  @Override
  public PersonDto save(PersonDto dto) {
 
    return PersonDto.fromEntity(
    		personRepository.save(
    				PersonDto.toEntity(dto)
        )
    );
  }
  

	@Override
	public Optional<Person> findByEmail(String email) {
		return this.personRepository.findByMail(email);
	}

  @Override
  public PersonDto findById(Integer id) {
  
    return personRepository.findById(id)
        .map(PersonDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucun Client avec l'ID = " + id + " n' ete trouve dans la BDD")
        );
  }

  @Override
  public List<PersonDto> findAll() {
    return personRepository.findAll().stream()
        .map(PersonDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {

    personRepository.deleteById(id);
  }
  
  
  
	@Override
	public boolean saveUser(Person utilisateur) {
		utilisateur.setMail(utilisateur.getMail());
		utilisateur.setPassword(utilisateur.getPassword());

		if(this.personRepository.save(utilisateur)!=null) return true;
		else 
			return false;
	}
}
