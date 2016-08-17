package com.aps.inv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aps.inv.domain.Component;

@Repository
@EnableTransactionManagement
public interface ComponentRepository extends JpaRepository<Component, Long> {

	Component findByComponentId(int componentId);

	String deleteByComponentId(int componentId);

	//List<Component> findByPartyId(int id); 
	 


}




