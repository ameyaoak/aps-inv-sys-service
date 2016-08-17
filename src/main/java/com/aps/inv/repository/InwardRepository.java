package com.aps.inv.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aps.inv.domain.Component;
import com.aps.inv.domain.Inward;

@Repository
@EnableTransactionManagement
public interface InwardRepository extends JpaRepository<Inward, Long> {
 
	@Transactional 
	void deleteByInwardNo(int inwardNo);

	Inward findByInwardNo(int inno);

	Component findComponentByInwardNo(int inwardId);
	 
	Component getComponentByInwardNo(int inwardId);

	//List<Inward> findByComonentId(int componentId);  

}
