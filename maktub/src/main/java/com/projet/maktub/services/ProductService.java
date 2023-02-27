package com.projet.maktub.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.projet.maktub.model.Product;


public interface ProductService {
	
	  Product saveProduct(Product product);

	  Optional<Product>   findByIdpro(Integer id);
	 
	  
      Product updateProduct(Product product);


	  boolean deleteProduct(Product product);
	  
	  Set<Product> getAllProducts();

}
