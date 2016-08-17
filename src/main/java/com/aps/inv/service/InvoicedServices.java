package com.aps.inv.service;

import java.util.List;

import com.aps.inv.domain.Invoiced;
 
public interface InvoicedServices {

	Invoiced getInvoiceByInvoiceId(int id); 

	List<Invoiced> getAllInvoices();

	Invoiced saveInvoiceDeltails(Invoiced invoice); 
 
	Invoiced updateInvoice(Invoiced invoice);

	void removeInvoice(int invoiceId); 
}
