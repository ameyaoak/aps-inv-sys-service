package com.aps.inv.service;

import java.util.List;
import java.util.Set;

import com.aps.inv.domain.Component;
import com.aps.inv.domain.MicroGridRow;
import com.aps.inv.domain.TCGridRow;
 
public interface ComponentService {

	List<Component> getComponentsByPartyId(int id);

	Component saveComponent(Component component);

	Component updateComponent(int componentId, Component component);

	Component getComponentsById(int componentId);

	String removeComponentById(int componentId);

	List<Component> getAllComponents();
  
	Set<TCGridRow> getComponentsTcGridById(int componentId);

	MicroGridRow getComponentsMicroGridById(int componentId);
   

}
