package com.aps.inv.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.assertj.core.internal.Dates;
import org.assertj.core.util.Lists;
import org.springframework.util.CollectionUtils;

import com.aps.inv.domain.Component;
import com.aps.inv.domain.DispatchResponceDto;
import com.aps.inv.domain.Dispatched;
import com.aps.inv.domain.Inward;
import com.aps.inv.domain.InwardResponceDto;

@org.springframework.stereotype.Component
public class ConvertorUtils {

	public InwardResponceDto convertInwardTOInwardResponceDto(Inward inward){
		Component component = new Component();
		component=inward.getComponent();
		InwardResponceDto inwardResponceDto = new InwardResponceDto(); 

		inwardResponceDto.setCreationDate(formatDate(inward.getCreationDate()));
		inwardResponceDto.setInwardNo(inward.getInwardNo());
		inwardResponceDto.setParty(inward.getComponent().getPartyName());
		inwardResponceDto.setComponent(component.getComponentName());
		inwardResponceDto.setMaterial(component.getMaterial());
		inwardResponceDto.setPartNo(component.getPartNo());
		inwardResponceDto.setProcess(component.getProcess());
		inwardResponceDto.setQtyKgs(inward.getQtyKgs());
		inwardResponceDto.setQtyNos(inward.getQtyNos());
		inwardResponceDto.setRateKg(component.getRateKg());
		inwardResponceDto.setRateNos(component.getRateNos());
		return inwardResponceDto;
	}

	private String formatDate(Date date) {
		if(null!=date){
		return new SimpleDateFormat("yyyy-MMM-dd").format(date); 
		}
		return null;
	}

	public List<DispatchResponceDto> convertDispatchTODispatchResponceDto(Inward inward){
		Component component = new Component();
		component=inward.getComponent();
		Set<Dispatched> dispatchs = inward.getDispatches();
		List<DispatchResponceDto> dispatchResponceDtoList = Lists.newArrayList(); 

		for(Dispatched dispatched : dispatchs){
			if(CollectionUtils.isEmpty(dispatched.getInvoices())){
			DispatchResponceDto dispatchResponceDto = new DispatchResponceDto();
			dispatchResponceDto.setDispatchNo(dispatched.getDispatchNo());
			dispatchResponceDto.setCreationDate(formatDate(dispatched.getCreationDate())); 
			dispatchResponceDto.setInwardNo(dispatched.getInwardNo());
			dispatchResponceDto.setComponentId(component.getComponentId());
			dispatchResponceDto.setParty(component.getPartyName());
			dispatchResponceDto.setComponent(component.getComponentName());
			dispatchResponceDto.setMaterial(component.getMaterial());
			dispatchResponceDto.setPartNo(component.getPartNo());
			dispatchResponceDto.setProcess(component.getProcess());
			dispatchResponceDto.setQtyKgs(dispatched.getQtyKgs());
			dispatchResponceDto.setQtyNos(dispatched.getQtyNos());
			dispatchResponceDto.setRateKg(component.getRateKg());
			dispatchResponceDto.setRateNos(component.getRateNos());
			dispatchResponceDto.setTotal(dispatched.getTotal());
			dispatchResponceDtoList.add(dispatchResponceDto);
			}
		}
		return dispatchResponceDtoList;
	}
	
	public List<DispatchResponceDto> convertInvoicedTOInvoicedResponceDto(Inward inward){
		Component component = new Component();
		component=inward.getComponent();
		Set<Dispatched> dispatchs = inward.getDispatches();
		List<DispatchResponceDto> dispatchResponceDtoList = Lists.newArrayList(); 

		for(Dispatched dispatched : dispatchs){
			DispatchResponceDto dispatchResponceDto = new DispatchResponceDto();
			dispatchResponceDto.setDispatchNo(dispatched.getDispatchNo());
			dispatchResponceDto.setCreationDate(formatDate(dispatched.getCreationDate())); 
			dispatchResponceDto.setInwardNo(dispatched.getInwardNo());
			dispatchResponceDto.setComponentId(component.getComponentId());
			dispatchResponceDto.setParty(component.getPartyName());
			dispatchResponceDto.setComponent(component.getComponentName());
			dispatchResponceDto.setMaterial(component.getMaterial());
			dispatchResponceDto.setPartNo(component.getPartNo());
			dispatchResponceDto.setProcess(component.getProcess());
			dispatchResponceDto.setQtyKgs(dispatched.getQtyKgs());
			dispatchResponceDto.setQtyNos(dispatched.getQtyNos());
			dispatchResponceDto.setRateKg(component.getRateKg());
			dispatchResponceDto.setRateNos(component.getRateNos());
			dispatchResponceDto.setTotal(dispatched.getTotal());
			dispatchResponceDtoList.add(dispatchResponceDto);
		}
		return dispatchResponceDtoList;
	}
}
