package com.aps.inv.domain;

import lombok.Data;
 
@Data
public class InvoicedResponceDto { 
	private int invoiceNo; 
	private String party,componentName, material,partNo,process,partyDc,partyDate; 
	private int dispatchNo,inwardNo,componentId; 
	private Double qtyKgs,  qtyNos, rateKg,  rateNos,total;
	private String creationDate;  
	private TestCertificate testCertificate;

}
