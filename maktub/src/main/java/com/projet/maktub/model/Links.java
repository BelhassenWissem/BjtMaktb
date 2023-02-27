package com.projet.maktub.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Links")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Links {
	
	@EmbeddedId
    private LinksID id;
	
	  @Column(name = "name")
	  private String name;
	
	 
	 
	  public Links(Person person , String url , String name  ) {
		super();
		this.id = new LinksID( url , person.getIdperson() );
	    this.name = name;
		this.person = person;
	}
	  
	  
	  


	 /* @ManyToOne
	  @JoinColumn(name = "idperson")
	  private Person person;*/
	
	  
	  @ManyToOne(fetch = FetchType.LAZY)
	    @MapsId("idperson")
	    private Person person;
	    
	  
}
