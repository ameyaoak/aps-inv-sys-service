package com.aps.inv.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Lists;
import org.springframework.util.CollectionUtils;

import com.aps.inv.domain.Component;
import com.aps.inv.domain.DispatchResponceDto;
import com.aps.inv.domain.Dispatched;
import com.aps.inv.domain.Invoiced;
import com.aps.inv.domain.InvoicedResponceDto;
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
		inwardResponceDto.setPartyDc(inward.getPartyDc());
		inwardResponceDto.setPartyDate(inward.getPartyDate());
		inwardResponceDto.setComponent(component.getComponentName());
		inwardResponceDto.setMaterial(component.getMaterial());
		inwardResponceDto.setPartNo(component.getPartNo());
		inwardResponceDto.setProcess(component.getProcess());
		inwardResponceDto.setQtyKgs(inward.getQtyKgs());
		inwardResponceDto.setQtyNos(inward.getQtyNos());
		inwardResponceDto.setRateKg(component.getRateKg());
		inwardResponceDto.setRateNos(component.getRateNos());
		
		inwardResponceDto.setWtt(component.getWtt());
		inwardResponceDto.setCoreHd(component.getCoreHd());
		inwardResponceDto.setCaseDepth(component.getCaseDepth());
		inwardResponceDto.setMicro(component.getMicro());
		inwardResponceDto.setDistortation(component.getDistortation());
		inwardResponceDto.setSurfaceHd(component.getSurfaceHd());
		inwardResponceDto.setLayerThickness(component.getLayerThickness());
		inwardResponceDto.setApperance(component.getApperance());
		inwardResponceDto.setAsQuenchHd(component.getAsQuenchHd());
		inwardResponceDto.setHdAfterTemp(component.getHdAfterTempering());
		inwardResponceDto.setPartialDecarb(component.getPartialDecarb()); 
		
		inwardResponceDto.setRemark(inward.getRemark());
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
			dispatchResponceDto.setPartyDc(inward.getPartyDc());
			dispatchResponceDto.setPartyDate(inward.getPartyDate());
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
	
	 
	
	public InvoicedResponceDto convertInvoicedTOInvoicedResponceDto(Invoiced invoiced){
		InvoicedResponceDto invoicedResponceDto = new InvoicedResponceDto();
		invoicedResponceDto.setComponentId(invoiced.getComponentId());
		invoicedResponceDto.setComponentName(invoiced.getComponentName());
		invoicedResponceDto.setCreationDate(formatDate(invoiced.getCreationDate()));
		invoicedResponceDto.setDispatchNo(invoiced.getDispatchNo());
		invoicedResponceDto.setInvoiceNo(invoiced.getInvoiceNo());
		invoicedResponceDto.setInwardNo(invoiced.getInwardNo());
		invoicedResponceDto.setMaterial(invoiced.getMaterial());
		invoicedResponceDto.setPartNo(invoiced.getPartNo());
		invoicedResponceDto.setProcess(invoiced.getProcess());
		invoicedResponceDto.setParty(invoiced.getParty()); 
		invoicedResponceDto.setPartyDc(invoiced.getPartyDc()); 
		invoicedResponceDto.setPartyDate(invoiced.getPartyDate()); 
		invoicedResponceDto.setQtyKgs(invoiced.getQtyKgs());
		invoicedResponceDto.setQtyNos(invoiced.getQtyNos());
		invoicedResponceDto.setRateKg(invoiced.getRateKg());
		invoicedResponceDto.setRateNos(invoiced.getRateNos()); 
		invoicedResponceDto.setTestCertificate(invoiced.getTestCertificate()); 
		invoicedResponceDto.setTaxableAmount(invoiced.getAmount());
		invoicedResponceDto.setCGST(invoiced.getTax()/2);
		invoicedResponceDto.setSGST(invoiced.getTax()/2); 
		invoicedResponceDto.setTotalTax(invoiced.getTax()); 
		invoicedResponceDto.setTotal((double) Math.round(invoiced.getTotal()));  
		return invoicedResponceDto;
	
	}
	public List<InvoicedResponceDto> convertInvoicedListTOInvoicedResponceDtoList(List<Invoiced> invoiced){
		List<InvoicedResponceDto> invoicedResponceDtos = Lists.newArrayList();
		for (Invoiced invoice : invoiced) {
			InvoicedResponceDto invoicedResponceDto = convertInvoicedTOInvoicedResponceDto(invoice);
			invoicedResponceDtos.add(invoicedResponceDto);
		}
		return invoicedResponceDtos; 
		
	
		 
	}
}
