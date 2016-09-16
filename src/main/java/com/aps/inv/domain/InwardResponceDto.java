package com.aps.inv.domain;

import lombok.Data;

@Data
public class InwardResponceDto {

	String creationDate;
	int inwardNo;
	String party,component,material,partNo,process,remark;
	double qtyKgs,qtyNos,rateKg,rateNos;
	 	
}
