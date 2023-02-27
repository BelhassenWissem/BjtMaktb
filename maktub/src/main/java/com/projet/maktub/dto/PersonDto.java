package com.projet.maktub.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.projet.maktub.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PersonDto {

	  private Integer id;

	  private String nom;

	  private String prenom;

	  private String email;
	  
	  private String tel;
	  
	  private String adresse;

	  private String password;

	  private byte[] photo;
	  /*

	  private List<RoleDto> roles;
	  
	  */
	  @JsonIgnore
	  private List<LinksDto> links;
	  
	
	  
	  @JsonIgnore
	  private List<OrderClientDto> orderCliens;
	  
	  
	  
	  
	  public static PersonDto fromEntity(Person person) {
	    if (person == null) {
	      return null;
	    }

	    return PersonDto.builder()
	        .id(person.getIdperson())
	        .nom(person.getNom())
	        .prenom(person.getPrenom())
	        .email(person.getMail())
	        .tel(person.getTel())
	        .adresse(person.getAdresse())
	        .password(person.getPassword())
	        .photo(person.getPhoto())
	      /*  .roles(
	        		person.getRoles() != null ?
	        				person.getRoles().stream()
	                    .map(RolesDto::fromEntity)
	                    .collect(Collectors.toList()) : null
	        )*/
	        .build();
	  }

	  public static Person toEntity(PersonDto dto) {
	    if (dto == null) {
	      return null;
	    }

	    Person person = new Person();
	    person.setIdperson(dto.getId());
	    person.setNom(dto.getNom());
	    person.setPrenom(dto.getPrenom());
	    person.setTel(dto.getTel());
	    person.setAdresse(dto.getAdresse());
	    person.setMail(dto.getEmail());
	    person.setPhoto(dto.getPhoto());

	    return person;
	  }
	}
