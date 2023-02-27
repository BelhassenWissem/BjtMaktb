package com.projet.maktub.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.maktub.model.Links;
import com.projet.maktub.model.OrderClient;
import com.projet.maktub.model.Person;
import com.projet.maktub.model.Product;
import com.projet.maktub.repository.PersonRepository;
import com.projet.maktub.services.LinksService;

@Service
public class LinksServiceImpl implements LinksService {


	@Autowired
	PersonRepository personRepository;
	
	
	@Override
	public boolean addLinkToUser(Person person,  String name , String url) {
		Person persond;
		persond =  this.personRepository.findByMail(person.getMail()).get();
		 Links linkDone;
		 linkDone = new Links(persond, name , url);
		 if(persond!=null) {
				if(persond.getLinks().add(linkDone)) {
					this.personRepository.save(persond);
					return true;
				}
				}
				return false;
	}

	
	
	

	@Override
	public boolean removeLinkFromUser(Person user , String url, String name ) {
		if(user!=null) {
			Links link = new Links(user, url , name);
			
			if(user.getLinks().remove(link)) {
				this.personRepository.save(user);
				return true;
			}
		
			}
			return false;
			
	}
	
	
	
	@Override
	public List<Links> getAlluserLinks(String mail) {
		Person person;
		person =  this.personRepository.findByMail(mail).get();
		 List<Links> liste = new ArrayList<>();
		 if(person!=null) {
			liste = person.getLinks();

					}
		return liste;
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
}
