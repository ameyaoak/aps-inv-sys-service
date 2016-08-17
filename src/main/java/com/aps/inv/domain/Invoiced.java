package com.aps.inv.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity  
@Table(name="invoiced")
public class Invoiced {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int invoiceNo;
	
	private String party,componentName, material;
	
	private int dispatchNo,inwardNo,componentId;
	
	private Double qtyKgs,  qtyNos, rateKg,  rateNos,total;
	private Date creationDate = new Date(); 
	
	@OneToOne
	@JoinColumn(name="tcNo")
	private TestCertificate testCertificate;
}