package com.projet.maktub.services;

import java.util.List;

import com.projet.maktub.dto.OrderClientDto;
import com.projet.maktub.model.OrderClient;
import com.projet.maktub.model.Person;
import com.projet.maktub.model.Product;


public interface OrderClientService {
	
	boolean addProductDoneToUser(Product product, Person person,  String code , int qte);
	List<OrderClient> getAlluserDoneProducts(String email);
	boolean removeProductDoneFromUser(Product productToRemove,Person person , String code , int qte);
	 

}
