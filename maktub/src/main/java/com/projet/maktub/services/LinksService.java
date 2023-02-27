package com.projet.maktub.services;

import java.util.List;

import com.projet.maktub.model.Links;
import com.projet.maktub.model.Person;

public interface LinksService {

	boolean addLinkToUser(Person person,  String name , String url);
	boolean removeLinkFromUser(Person person  , String url , String name) ;
	List<Links> getAlluserLinks(String mail) ;

}
