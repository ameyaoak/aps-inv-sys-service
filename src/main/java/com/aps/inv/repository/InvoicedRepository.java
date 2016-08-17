package com.aps.inv.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aps.inv.domain.Invoiced; 

@Repository
@EnableTransactionManagement
public interface InvoicedRepository extends JpaRepository<Invoiced, Long> { 
	@Transactional 
	public void deleteByInvoiceNo(int invoiceId);

	public Invoiced findByInvoiceNo(int id);
 


}




