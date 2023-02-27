package com.projet.maktub.dto;

import com.projet.maktub.model.Links;
import lombok.Builder;
import lombok.Data;


	@Data
	@Builder
	public class LinksDto {
		
		
		 private Integer id;
		
		 private String name;
		 
		 private String url;
		

		  
		  public static LinksDto fromEntity(Links links) {
		    if (links == null) {
		      return null;
		    }

		    return LinksDto.builder()
		        .name(links.getName())
		        .build();
		      
		  }

		  public static Links toEntity(LinksDto dto) {
		    if (dto == null) {
		      return null;
		    }

		    Links links = new Links();
		    links.setName(dto.getName());
		  


		    return links;
		  }
	}

	
