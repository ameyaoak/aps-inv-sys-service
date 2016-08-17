package com.aps.inv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aps.inv.domain.Component;
import com.aps.inv.domain.MicroGridRow;
import com.aps.inv.domain.TCGridRow;
import com.aps.inv.service.ComponentService;
 

@RestController
@RequestMapping("/component")
public class ComponentController {

	@Autowired
	ComponentService componentService;
	
	@RequestMapping(value = "/partyId/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public List<Component> getComponentsByPartyId(@PathVariable("id") int id) { 
		return componentService.getComponentsByPartyId(id);
	}
 
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Component getComponentsById(@PathVariable("id") int id) { 
		return componentService.getComponentsById(id);
	}
	
//	@RequestMapping(value = "tcGrid/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
//	public List<TCGridRow> getComponentsTcGridById(@PathVariable("id") int id) { 
//		return componentService.getComponentsTcGridById(id);
//	}
	
	@RequestMapping(value = "microGrid/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public MicroGridRow getComponentsMicroGridById(@PathVariable("id") int id) { 
		return componentService.getComponentsMicroGridById(id);
	}

	@RequestMapping(value = "/all" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)  
	public List<Component> getAllComponents() {
		return componentService.getAllComponents();
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)  
	public Component saveComponent(@RequestBody Component component) { 
		return componentService.saveComponent(component);
	}

	@RequestMapping(value = "/{id}" ,method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)  
	public Component updateComponent(@PathVariable("id") int id,@RequestBody Component component) { 
		return componentService.updateComponent(id,component);
	}

	@RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)  
	public String removeComponentById(@PathVariable("id") int id) { 
		return componentService.removeComponentById(id);
	}
}

