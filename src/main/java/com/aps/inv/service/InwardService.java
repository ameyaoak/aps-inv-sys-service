package com.aps.inv.service;

import java.util.List;

import com.aps.inv.domain.Component;
import com.aps.inv.domain.DispatchResponceDto;
import com.aps.inv.domain.Inward;
import com.aps.inv.domain.InwardResponceDto;
 
public interface InwardService { 
	Inward saveInwardDeltails(Inward inward); 
	List<Inward> getAllInwards();
	Inward updateInward(Inward inward); 
	Inward getInwardDetailsByInwardNo(int inno); 
	List<InwardResponceDto> getAllInwardsForDisplay();
	void removeInwardsEntry(int inwardNo); 
	Component getComponentForInward(int inwardId);
	List<DispatchResponceDto> getAllDispatchForDisplay(); 
}
