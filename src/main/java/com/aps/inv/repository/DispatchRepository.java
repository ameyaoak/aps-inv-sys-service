package com.aps.inv.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aps.inv.domain.Dispatched; 

@Repository
@EnableTransactionManagement
public interface DispatchRepository extends JpaRepository<Dispatched, Long> {
  
	 
	@Transactional
	void deleteByDispatchNo(int id);  
	List<Dispatched> findByInwardNo(int inno);  
	Dispatched findByDispatchNo(int id);
 

 
 
}

