package com.aps.inv.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.inv.domain.Component;
import com.aps.inv.domain.MicroGridRow;
import com.aps.inv.domain.TCGridRow;
import com.aps.inv.repository.ComponentRepository;
import com.aps.inv.service.ComponentService; 
@Service
public class ComponentServicesImpl implements ComponentService{
	
	@Autowired
	private ComponentRepository componentRepository;
	 
	 
	@Override
	public List<Component> getComponentsByPartyId(int id) {
		return null; 
	    //	return componentRepository.findByPartyId(id);
	}

	@Override
	public Component saveComponent(Component component) {
		return componentRepository.save(component);
	}

	@Override
	public Component updateComponent(int componentId, Component component) { 
		return componentRepository.save(component); 
	}

	@Override
	public Component getComponentsById(int componentId) {
		return componentRepository.findByComponentId(componentId);
	}

	@Override
	public String removeComponentById(int componentId) {
		return componentRepository.deleteByComponentId(componentId);
	}

	@Override
	public List<Component> getAllComponents() { 
		return componentRepository.findAll();
	}

	@Override
	public Set<TCGridRow> getComponentsTcGridById(int componentId) {
		Component component = componentRepository.findByComponentId(componentId);
		Set<TCGridRow> gridRows = Sets.newHashSet(); 
		if(StringUtils.isNotBlank(component.getApperance())){
			TCGridRow gridRow=new TCGridRow();
			gridRow.setParticular("Apperance");
			gridRow.setActuals(component.getApperance());
			gridRows.add(gridRow);
		}
		if(StringUtils.isNotBlank(component.getSurfaceHd())){
			TCGridRow gridRow=new TCGridRow();
			gridRow.setParticular("Surface Hd");
			gridRow.setActuals(component.getSurfaceHd());
			gridRows.add(gridRow);
		}
		if(StringUtils.isNotBlank(component.getCaseDepth())){
			TCGridRow gridRow=new TCGridRow();
			gridRow.setParticular("Case Depth");
			gridRow.setActuals(component.getCaseDepth());
			gridRows.add(gridRow);
		}
		if(StringUtils.isNotBlank(component.getCoreHd())){
			TCGridRow gridRow=new TCGridRow();
			gridRow.setParticular("Core Hd");
			gridRow.setActuals(component.getCoreHd());
			gridRows.add(gridRow);
		}
		if(StringUtils.isNotBlank(component.getCrack())){
			TCGridRow gridRow=new TCGridRow();
			gridRow.setParticular("Crack");
			gridRow.setActuals(component.getCrack());
			gridRows.add(gridRow);
		}
		if(StringUtils.isNotBlank(component.getSf())){
			TCGridRow gridRow=new TCGridRow();
			gridRow.setParticular("SF");
			gridRow.setActuals(component.getSf());
			gridRows.add(gridRow);
		}
		if(StringUtils.isNotBlank(component.getWtt())){
			TCGridRow gridRow=new TCGridRow();
			gridRow.setParticular("Wtt");
			gridRow.setActuals(component.getWtt());
			gridRows.add(gridRow);
		}
		if(StringUtils.isNotBlank(component.getMicro())){
			TCGridRow gridRow=new TCGridRow();
			gridRow.setParticular("Micro");
			gridRow.setActuals(component.getMicro());
			gridRows.add(gridRow);
		}
		if(StringUtils.isNotBlank(component.getDistortation())){
			TCGridRow gridRow=new TCGridRow();
			gridRow.setParticular("Distortation");
			gridRow.setActuals(component.getDistortation());
			gridRows.add(gridRow);
		}
		if(StringUtils.isNotBlank(component.getLayerThickness())){
			TCGridRow gridRow=new TCGridRow();
			gridRow.setParticular("LayerThickness");
			gridRow.setActuals(component.getLayerThickness());
			gridRows.add(gridRow);
		}
		return gridRows;
	}
	
	@Override
	public MicroGridRow getComponentsMicroGridById(int componentId) { 
		MicroGridRow gridRow = new MicroGridRow(); 
		gridRow.setCut("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14");
		gridRow.setHv("13,44,56,24,11,33,44,1, 32, 11, 12, 23, 15,20");
		gridRow.setMm("11, 32, 11, 12, 23, 15, 50,13,44,56,24,11,33,44");
		return gridRow;
	}
	
}