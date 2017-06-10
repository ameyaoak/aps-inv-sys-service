package com.aps.inv.domain;

import lombok.Data;

@Data
public class DispatchResponceDto {
	
	private int inwardNo,dispatchNo,componentId;
	private String creationDate; 
	private String party,component,material,partNo,process,partyDc,partyDate;
	private double qtyKgs,qtyNos,rateKg,rateNos,total;

}
