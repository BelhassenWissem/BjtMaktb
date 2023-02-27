package com.projet.maktub.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class LinksID implements Serializable {

	public LinksID() {}
	
	
	private static final long serialVersionUID = 1L;

    @Column(name = "idperson")
    private Integer idperson;
    
  
    
    @Column(name = "url")
    private String url;
    
    

    
    public LinksID(
    		
    		String url,
    		Integer idperson) {
        this.idperson = idperson;
        this.url = url;
    }

    
    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        LinksID that = (LinksID) o;
        return 
               Objects.equals(idperson, that.idperson)  && 
               Objects.equals(url, that.url);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(idperson ,  url);
    }
    
}

