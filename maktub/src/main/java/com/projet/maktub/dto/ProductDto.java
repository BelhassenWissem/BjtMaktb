package com.projet.maktub.dto;

import com.projet.maktub.model.Product;

import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class ProductDto {


	  private Integer id;

	  private String nom;

	  private String description;

	  private float  prix;

	  private byte[] picture;


	  public static ProductDto fromEntity(Product product) {
	    if (product == null) {
	      return null;
	    }

	    return ProductDto.builder()
	        .id(product.getIdpro())
	        .nom(product.getNom())
	        .description(product.getDescription())
	        .prix(product.getPrix())
	        .picture(product.getPicture())
	      
	        .build();
	  }

	  public static Product toEntity(ProductDto dto) {
	    if (dto == null) {
	      return null;
	    }

	    Product product = new Product();
	    product.setIdpro(dto.getId());
	    product.setNom(dto.getNom());
	    product.setDescription(dto.getDescription());
	    product.setPrix(dto.getPrix());
	    product.setPicture(dto.getPicture());

	    return product;
	  
	}

}