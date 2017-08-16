package com.aps.inv.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity  
@Table(name="invoiced")
public class Invoiced {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="InvoiceSeq")
	@SequenceGenerator(
		name="InvoiceSeq",
		sequenceName="INVOICE_SEQ",
		allocationSize=1,
		initialValue=0
	)
	private int invoiceNo;
	
	private String party,componentName, material,partNo,process,partyDc,partyDate;
	
	private int dispatchNo,inwardNo,componentId;
	
	private Double qtyKgs,  qtyNos, rateKg,  rateNos,amount,total;
	
	@Column(precision=7, scale=2)
	private Double tax;
	
	private Date creationDate = new Date(); 
	
	@OneToOne
	@JoinColumn(name="tcNo")
	private TestCertificate testCertificate;
}