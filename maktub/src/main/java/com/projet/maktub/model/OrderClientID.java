package com.projet.maktub.model;

import java.io.Serializable;
import javax.persistence.Column;
import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class OrderClientID implements Serializable {
	
	
	public OrderClientID() {}
	
	private static final long serialVersionUID = 1L;

	
	@Column(name = "idpro")
    private Integer idpro;
 
    @Column(name = "idperson")
    private Integer idperson;
 
    
    
 
    public OrderClientID(
    		Integer idpro, 
    		Integer idperson) {
        this.idpro = idpro;
        this.idperson = idperson;
    }

    
    
    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        OrderClientID that = (OrderClientID) o;
        return Objects.equals(idpro, that.idpro) && 
               Objects.equals(idperson, that.idperson);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(idpro, idperson);
    }
    
    
    
    
    
    
    
    
}
