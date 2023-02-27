package com.projet.maktub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.projet.maktub.model.Links;
import com.projet.maktub.model.OrderClient;
import com.projet.maktub.model.Person;
import com.projet.maktub.model.Product;
import com.projet.maktub.repository.PersonRepository;
import com.projet.maktub.repository.ProductRepository;
import com.projet.maktub.services.LinksService;
import com.projet.maktub.services.OrderClientService;
import com.projet.maktub.services.PersonService;


@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("links")

public class LinksController {


	@Autowired 
	PersonService utilisateurService;
	

	@Autowired 
	LinksService linkService;
	
	@Autowired 
	PersonRepository       personRepository;
	
	@Autowired 
	OrderClientService    orderClientService;
	
	
	
	
	@PostMapping(path="/addLinkToUser")
	public ResponseEntity<Links> addLinkToUser(@RequestBody ObjectNode json){
		Person person = new Person();
		Links linkToAdd = new Links();
		try {
			person = new ObjectMapper().treeToValue(json.get("person"), Person.class);
			String name = new ObjectMapper().treeToValue(json.get("name"), String.class);
			String url = new ObjectMapper().treeToValue(json.get("url"), String.class);

			boolean test = this.linkService.addLinkToUser(person, name , url);
			if(test)
			return new ResponseEntity<Links>(linkToAdd,HttpStatus.OK);

		} catch (JsonProcessingException e) {
			System.out.println("Parsing Exception!!");
			e.printStackTrace();
			return new ResponseEntity<Links>(HttpStatus.NOT_ACCEPTABLE);

		}
		return new ResponseEntity<Links>(HttpStatus.NOT_ACCEPTABLE);

	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Links>> getAllUserLinks
					(@RequestParam(value="email", required=true) String email){
		List<Links> listeLinks = this.linkService.getAlluserLinks(email);
		
		if(listeLinks!=null) {
			return new ResponseEntity<List<Links>>(listeLinks,HttpStatus.OK);
		}
		else 
			return new ResponseEntity<List<Links>>(listeLinks,HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	

	@PostMapping(path="/deleteLinkFromUser")
	public ResponseEntity<Boolean> deleteLinkFromUser(@RequestBody ObjectNode jso){
		Person user = new Person();
		
			/*String name = jso.get("name").asText();
			String url = jso.get("url").asText();
			String email = jso.get("email").asText();
			int idlink = jso.get("idlink").asInt();*/
			
			user = this.personRepository.findByMail("kkk@kkk").get();
			
			boolean done = this.linkService.removeLinkFromUser(user  , "kkk" , "kkk");
		return new ResponseEntity<Boolean>(done,HttpStatus.OK);
		
		
		
		

	}
	
	
	
	
	
	
	
	
	
	
}
