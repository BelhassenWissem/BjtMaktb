package com.projet.maktub.dto;

import java.time.Instant;
import javax.persistence.EmbeddedId;

import com.projet.maktub.model.OrderClient;
import com.projet.maktub.model.OrderClientID;
import com.projet.maktub.model.OrderStatus;



import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class OrderClientDto {

	
	@EmbeddedId
    private OrderClientID id;
	  
	  private PersonDto person;
	  
	  private ProductDto product;

	  private String code;

	  private String orderStatus;

	  private Instant orderDate;
	  
	  private int quantite ;

	  


	  public static OrderClientDto fromEntity(OrderClient orderClient) {
	    if (orderClient == null) {
	      return null;
	    }
	    return OrderClientDto.builder()
	        .id(orderClient.getId())
	        .code(orderClient.getCode())
	       /* .orderDate(orderClient.getOrderdate())
	        .orderStatus(orderClient.getOrderstatus())*/
	        .quantite(orderClient.getQuantite())
	        .person(PersonDto.fromEntity(orderClient.getPerson()))
	        .product(ProductDto.fromEntity(orderClient.getProduct()))
	        		
	        .build();

	  }

	  public static OrderClient toEntity(OrderClientDto dto) {
	    if (dto == null) {
	      return null;
	    }
	    OrderClient orderClient = new OrderClient();
	    orderClient.setId(dto.getId());
	    orderClient.setCode(dto.getCode());
	    orderClient.setQuantite(dto.getQuantite());
	  /*  orderClient.setOrderstatus(dto.getOrderStatus());
	    orderClient.setOrderdate(dto.getOrderDate());*/
	  
	    return orderClient;
	  }

	
	}



