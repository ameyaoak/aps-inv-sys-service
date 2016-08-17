package com.aps.inv.domain;

import java.util.Date;

import lombok.Data;

@Data
public class InwardResponceDto {

	String creationDate;
	int inwardNo;
	String party,component,material,partNo,process;
	double qtyKgs,qtyNos,rateKg,rateNos;
	 	
}
