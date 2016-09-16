package com.aps.inv.service.impl;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.inv.domain.Component;
import com.aps.inv.domain.DispatchResponceDto;
import com.aps.inv.domain.Inward;
import com.aps.inv.domain.InwardResponceDto;
import com.aps.inv.repository.InwardRepository;
import com.aps.inv.service.InwardService;
import com.aps.inv.utils.ConvertorUtils;
 
@Service
public class InwardServicesImpl implements InwardService{

	@Autowired
	private InwardRepository inwardRepository;
	  
	@Autowired
	private ConvertorUtils converterUtils;

	@Override
	public Inward getInwardDetailsByInwardNo(int inwardNo) {
		return inwardRepository.findByInwardNo(inwardNo);
	}

	@Override
	public Inward saveInwardDeltails(Inward inward) {
		return inwardRepository.save(inward);
	}

	@Override
	public void removeInwardsEntry(int inwardNo) {
		inwardRepository.deleteByInwardNo(inwardNo);
	}

	@Override
	public List<Inward> getAllInwards() { 
		return  inwardRepository.findAll(); 
	}

	@Override
	public Inward updateInward(Inward inward) {
		 return inwardRepository.save(inward);  
	} 
	 

	@Override
	public List<InwardResponceDto> getAllInwardsForDisplay() {
		List<InwardResponceDto> inwardResponceDtos = Lists.newArrayList();
		for (Inward inward : inwardRepository.findAll()) {
			if(inward.getQtyKgs() >= 0 && inward.getQtyNos() >= 0 && inward.getQtyKgs()+inward.getQtyNos()>0){
			inwardResponceDtos.add(converterUtils.convertInwardTOInwardResponceDto(inward));
			}
		}
		return inwardResponceDtos; 
	}

	
	
	@Override
	public Component getComponentForInward(int inwardId) {
		return inwardRepository.getComponentByInwardNo(inwardId);
	}

	@Override
	public List<DispatchResponceDto> getAllDispatchForDisplay() {
		List<DispatchResponceDto> dispatchResponceDto = Lists.newArrayList();
		for (Inward inward : inwardRepository.findAll()) { 
				dispatchResponceDto.addAll(converterUtils.convertDispatchTODispatchResponceDto(inward));
			}
		return dispatchResponceDto;  
	}
 

}
