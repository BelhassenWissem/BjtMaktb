package com.projet.maktub.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.maktub.model.OrderClient;

public interface OrderClientRepository extends JpaRepository<OrderClient, Integer> {
	
}