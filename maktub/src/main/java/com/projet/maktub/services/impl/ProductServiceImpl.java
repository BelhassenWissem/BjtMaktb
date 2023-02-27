package com.projet.maktub.services.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.maktub.model.Product;
import com.projet.maktub.repository.OrderClientRepository;
import com.projet.maktub.repository.ProductRepository;
import com.projet.maktub.services.ProductService;




@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;
  private OrderClientRepository orderClientRepository;

  @Autowired
  
  public ProductServiceImpl(ProductRepository productRepository, OrderClientRepository orderClientRepository) {
    this.orderClientRepository = orderClientRepository;
    this.orderClientRepository = orderClientRepository;
  }

  @Override
	public Product saveProduct(Product product) {
	  return	this.productRepository.save(product) ;
	 
	}
  


	@Override
	public Product updateProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public Set<Product> getAllProducts() {
		return new HashSet<Product>( this.productRepository.findAll());
	}


	@Override
	public boolean deleteProduct(Product product) {
		 this.productRepository.delete(product);
		 return true;
	}
	
	@Override
	public Optional<Product>  findByIdpro(Integer idpro) {
		return this.productRepository.findById(idpro);
	}


}
