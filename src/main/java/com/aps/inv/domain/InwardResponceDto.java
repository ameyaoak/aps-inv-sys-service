package com.aps.inv.domain;

import lombok.Data;

@Data
public class InwardResponceDto {

	String creationDate;
	int inwardNo;
	String party,component,material,partNo,process,remark,partyDc,partyDate;
	double qtyKgs,qtyNos,rateKg,rateNos;
	String coreHd, surfaceHd, caseDepth, micro, distortation, layerThickness, apperance, wtt;
	
	String partialDecarb,hdAfterTemp,asQuenchHd;
	 
	 	
}
