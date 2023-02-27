package com.projet.maktub.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	private Integer idpro;
	private String nom;
	private String description;
	@Column(name = "picture", length = 1000)
	private byte[] picture;
	
	private float prix ;
	
	
	
	public Product(Integer idpro, String nom, String description , float prix , byte[] picture) {
		super();
		this.idpro = idpro;
		this.nom = nom;
		this.description = description;
		this.picture = picture;
		this.prix = prix;
	}

	 @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
			@JsonIgnore
		    private List<OrderClient> orderClient = new ArrayList<OrderClient>();
	





}
