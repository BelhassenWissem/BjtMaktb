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
import com.projet.maktub.model.OrderClient;
import com.projet.maktub.model.Person;
import com.projet.maktub.model.Product;
import com.projet.maktub.repository.PersonRepository;
import com.projet.maktub.repository.ProductRepository;
import com.projet.maktub.services.OrderClientService;
import com.projet.maktub.services.PersonService;
import com.projet.maktub.services.ProductService;


@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("productsdone")

public class OrderClientController {
	
	
	@Autowired
	OrderClientService orderClientService;
	
	@Autowired 
	PersonService utilisateurService;
	@Autowired
	ProductService produitService;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	ProductRepository  productRepository;

	
	@PostMapping(path="/addProductDoneToUser")
	public ResponseEntity<Product> addProductDoneToUser(@RequestBody ObjectNode json){
		Person person = new Person();
		Product productToAdd = new Product();
		try {
			person = new ObjectMapper().treeToValue(json.get("person"), Person.class);
			productToAdd = new ObjectMapper().treeToValue(json.get("product"), Product.class);
			int qte = new ObjectMapper().treeToValue(json.get("qte"), Integer.class);
			String code = new ObjectMapper().treeToValue(json.get("code"), String.class);

			boolean test = this.orderClientService.addProductDoneToUser(productToAdd,person,code , qte);
			if(test)
			return new ResponseEntity<Product>(productToAdd,HttpStatus.OK);

		} catch (JsonProcessingException e) {
			System.out.println("Parsing Exception!!");
			e.printStackTrace();
			return new ResponseEntity<Product>(HttpStatus.NOT_ACCEPTABLE);

		}
		return new ResponseEntity<Product>(HttpStatus.NOT_ACCEPTABLE);

	}
	
	
	
	
	@PostMapping(path="/updateProductDone")
	public ResponseEntity<Product> updateProductDone(@RequestBody ObjectNode json){
		Person user = new Person();
		Product productToAdd = new Product();
		try {
			user = new ObjectMapper().treeToValue(json.get("user"), Person.class);
			productToAdd = new ObjectMapper().treeToValue(json.get("product"), Product.class);
			int qte = new ObjectMapper().treeToValue(json.get("qte"), Integer.class);
			String code = new ObjectMapper().treeToValue(json.get("code"), String.class);
			boolean test = this.orderClientService.addProductDoneToUser(productToAdd,user,code,qte);
			if(test)
			return new ResponseEntity<Product>(productToAdd,HttpStatus.OK);

		} catch (JsonProcessingException e) {
			System.out.println("Parsing Exception!!");
			e.printStackTrace();
			return new ResponseEntity<Product>(HttpStatus.NOT_ACCEPTABLE);

		}
		return new ResponseEntity<Product>(HttpStatus.NOT_ACCEPTABLE);

	}
	
	
	
	@GetMapping
	public ResponseEntity<List<OrderClient>> getAllUserDoneProducts
					(@RequestParam(value="email", required=true) String email){
		List<OrderClient> listeDone = this.orderClientService.getAlluserDoneProducts(email);
		
		if(listeDone!=null) {
			return new ResponseEntity<List<OrderClient>>(listeDone,HttpStatus.OK);
		}
		else 
			return new ResponseEntity<List<OrderClient>>(listeDone,HttpStatus.NOT_FOUND);
	}
	
	
	
	@PostMapping(path="/deleteDoneProductFromUser")
	public ResponseEntity<Boolean> deleteProductFromUser(@RequestBody ObjectNode jso){
		Person user = new Person();
		Product productToRemove = new Product();
		
			int idpro = jso.get("idpro").asInt();
			String code = jso.get("code").asText();
			int qte = jso.get("qte").asInt();
			String email = jso.get("email").asText();
			
			user = this.personRepository.findByMail(email).get();
			productToRemove = this.productRepository.findById(idpro).get();
			
			boolean done = this.orderClientService.removeProductDoneFromUser(productToRemove, user , code , qte);
		return new ResponseEntity<Boolean>(done,HttpStatus.OK);
		
		
		
		

	}

	
	
	
	
	
	
	
	
	

}
