package com.aps.inv.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity  
@Table(name="dispatched")
public class Dispatched {
 
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="DispatchSeq")
	@SequenceGenerator(
		name="DispatchSeq",
		sequenceName="DISPATCH_SEQ",
		allocationSize=1,
		initialValue=0
	) 
	private int dispatchNo;

	private int inwardNo;
	
	private Date creationDate = new Date();

	private double qtyKgs,qtyNos,rateKg,rateNos,total;

	@OneToMany(mappedBy="dispatchNo",cascade = CascadeType.ALL)
	private Set<Invoiced> invoices; 

}
