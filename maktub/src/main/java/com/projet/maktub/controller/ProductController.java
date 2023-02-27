package com.projet.maktub.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projet.maktub.model.Person;
import com.projet.maktub.model.Product;
import com.projet.maktub.repository.ProductRepository;
import com.projet.maktub.services.ProductService;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("products")
public class ProductController {
	
	
	

	@Autowired 
	ProductService productService;
	
	@Autowired
	ProductRepository  productRepository;
    
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String nom) {
		try {
			List<Product> products = new ArrayList<Product>();
				productRepository.findAll().forEach(products::add);
				productRepository.findByNom(nom).forEach(products::add);
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{idpro}")
	public ResponseEntity<Product> getProductById(@PathVariable("idpro") Integer idpro) {
		Optional<Product> productData = productRepository.findById(idpro);

		if (productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<Product> create(@RequestParam("idpro")Integer idpro,@RequestParam("nom")String nom,@RequestParam("prix")float prix,@RequestParam("description")String description ,@RequestParam(value = "picture", required = false) MultipartFile fichier) throws IOException {
		Product prod = new Product(idpro,nom,description,prix,fichier.getBytes());
		Product _product = productRepository.save(prod);
		return new ResponseEntity<>(_product, HttpStatus.CREATED);
	
	}
	
	
	
	@PutMapping("/{idpro}")
	public ResponseEntity<Product> updateProduct(@RequestParam("idpro")Integer idpro,@RequestParam("nom")String nom,@RequestParam("prix")float prix,@RequestParam("description")String description , @RequestParam(value = "picture", required = false) MultipartFile fichier ) throws IOException {
		Optional<Product> productData = productRepository.findById(idpro);

		if (productData.isPresent()) {
			Product _product = productData.get();
			_product.setIdpro(idpro);
			_product.setNom(nom);
			_product.setDescription(description);
			_product.setPrix(prix);
			_product.setPicture(fichier.getBytes());
			
			

			return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping("/{idpro}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("idpro") Integer idpro) {
		try {
	       productRepository.deleteById(idpro);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping
	public ResponseEntity<HttpStatus> deleteAllProducts() {
		try {
			productRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}



