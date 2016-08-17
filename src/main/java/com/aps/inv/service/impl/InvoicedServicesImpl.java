package com.aps.inv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.inv.domain.Invoiced;
import com.aps.inv.repository.InvoicedRepository;
import com.aps.inv.service.InvoicedServices; 

@Service
public class InvoicedServicesImpl implements InvoicedServices{
	
	@Autowired
	private InvoicedRepository invoicedRepository;

	@Override
	public Invoiced getInvoiceByInvoiceId(int id) { 
		return invoicedRepository.findByInvoiceNo(id);
	}
	 

	@Override
	public List<Invoiced> getAllInvoices() { 
		return invoicedRepository.findAll();
	}

	@Override
	public Invoiced saveInvoiceDeltails(Invoiced invoice) {
		return invoicedRepository.save(invoice);
	}

	@Override
	public Invoiced updateInvoice(Invoiced invoice) {
		return invoicedRepository.save(invoice);
	}

	@Override
	public void removeInvoice(int invoiceId) {
		invoicedRepository.deleteByInvoiceNo(invoiceId);
	} 

	 
 

}
