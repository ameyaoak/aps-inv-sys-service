package com.aps.inv.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity  
@Table(name="component")
public class Component {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int componentId; 
	private int partyId;
	private String componentName , partyName,material,partNo, process, poNo, poDate,
			coreHd, surfaceHd, caseDepth, crack, micro, distortation, sf, wtt,
			coreHdTestLocation, surfaceHdTestLocation, caseDepthTestLocation, crackTestLocation, microTestLocation, distortationTestLocation,
			coreHdTestMethod, surfaceHdTestMethod, caseDepthTestMethod, crackTestMethod, microTestMethod, distortationTestMethod,
			layerThickness, apperance, version,processPlanNo,sizeOfJob,routeCardNo,
			layerThicknessTestLocation, apperanceTestLocation,
			layerThicknessTestMethod, apperanceTestMethod;
 
	private double rateKg,rateNos;
}
