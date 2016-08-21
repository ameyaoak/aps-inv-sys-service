package com.aps.inv.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.inv.domain.Invoiced;
import com.aps.inv.domain.InvoicedResponceDto;
import com.aps.inv.domain.TCGridRow;
import com.aps.inv.domain.TestCertificate;
import com.aps.inv.repository.InvoicedRepository;
import com.aps.inv.repository.TCRepository;
import com.aps.inv.service.ComponentService;
import com.aps.inv.service.InvoicedServices;
import com.aps.inv.utils.ConvertorUtils; 

@Service
public class InvoicedServicesImpl implements InvoicedServices{
	
	@Autowired
	private InvoicedRepository invoicedRepository;
	
	@Autowired
	private ComponentService componentService;
	
	@Autowired
	private TCRepository tcRepository;
	
	@Autowired
	private ConvertorUtils convetorUtil;

	@Override
	public InvoicedResponceDto getInvoiceByInvoiceId(int id) { 
		return convetorUtil.convertInvoicedTOInvoicedResponceDto(invoicedRepository.findByInvoiceNo(id));
	}
	 

	@Override
	public List<InvoicedResponceDto> getAllInvoices() {  
		return convetorUtil.convertInvoicedListTOInvoicedResponceDtoList(invoicedRepository.findAll());
	}

	@Override
	public Invoiced saveInvoiceDeltails(Invoiced invoice,int componentId) {
		
		Set<TCGridRow> tcGrid = componentService.getComponentsTcGridById(componentId); 
		TestCertificate testCertificate = tcRepository.save(new TestCertificate());
		for (TCGridRow tcRow:tcGrid) {
			tcRow.setTcNo(testCertificate.getTcNo());
		}
		testCertificate.setGridRows(tcGrid);
		tcRepository.save(testCertificate); 
		 
		invoice.setTestCertificate(testCertificate);
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
