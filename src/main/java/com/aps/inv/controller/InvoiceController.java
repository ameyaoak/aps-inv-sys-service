package com.aps.inv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aps.inv.domain.Invoiced;
import com.aps.inv.service.InvoicedServices;
 


@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	InvoicedServices invoicedServices;

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/invoice/1
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Invoiced getInvoiceByInwardId(@PathVariable("id") int id) { 
		return invoicedServices.getInvoiceByInvoiceId(id);
	} 
	
	//http://localhost:8080/Jersey-Spring-Hibernate/rest/invoice/invoices/all
	@RequestMapping(value = "/all" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public List<Invoiced> getAllInwards() {
		return invoicedServices.getAllInvoices();
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/invoice
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Invoiced saveInvoice(@RequestBody Invoiced invoice) {  
		return invoicedServices.saveInvoiceDeltails(invoice);
	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Invoiced updateInvoice(@RequestBody Invoiced invoice) {  
		return invoicedServices.updateInvoice(invoice);
	}


	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE) 
	public void removeInvoice(@PathVariable("id") int id) { 
		 invoicedServices.removeInvoice(id);
	}
}

