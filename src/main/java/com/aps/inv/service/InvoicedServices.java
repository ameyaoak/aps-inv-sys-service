package com.aps.inv.service;

import java.util.List;

import com.aps.inv.domain.Invoiced;
import com.aps.inv.domain.InvoicedResponceDto;
 
public interface InvoicedServices {

	InvoicedResponceDto getInvoiceByInvoiceId(int id); 

	List<InvoicedResponceDto> getAllInvoices(); 
 
	Invoiced updateInvoice(Invoiced invoice);

	void removeInvoice(int invoiceId);

	Invoiced saveInvoiceDeltails(Invoiced invoice, int componentId); 
}
