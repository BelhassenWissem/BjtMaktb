package com.projet.maktub.model;


import java.time.Instant;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Orderclient")
@Table(name = "Orderclient")

public class OrderClient {

	@EmbeddedId
    private OrderClientID id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idpro")
    private Product product;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idperson")
    private Person person;
    

    @Column(name = "code")
    private String code;
  
 
    @Column(name = "quantite")
    private int quantite ;
    
    public OrderClient(Product produit, Person person,  String code,  int quantite) {
		super();
		this.id = new OrderClientID(produit.getIdpro(), person.getIdperson());
		this.product = produit;
		this.person = person;
		this.code =code;
		this.quantite = quantite;
	}
	
	/*
    @Column(name = "orderdate")
    private Instant orderdate;
    
    @Column(name = "orderstatus")
    private String orderstatus;
  */

    /*
    @Column(name = "orderstatus")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderstatus;
*/



}
