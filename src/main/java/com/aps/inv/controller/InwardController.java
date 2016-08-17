package com.aps.inv.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aps.inv.domain.DispatchResponceDto;
import com.aps.inv.domain.Inward;
import com.aps.inv.domain.InwardResponceDto;
import com.aps.inv.service.InwardService;
 

@RestController
@RequestMapping("/inward")
public class InwardController {

	@Autowired
	InwardService inwardService;

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/inward/1
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Inward getInwardByPartyId(@PathVariable("id") int id) { 
		return inwardService.getInwardDetailsByInwardNo(id);
	}
//
//	//http://localhost:8080/Jersey-Spring-Hibernate/rest/inward/partyId/eg
//	@RequestMapping(value = "partyId/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
//	public List<Inward> getInwardByPartyName(@PathVariable("id") int id) { 
//		return inwardService.getInwardDetailsByComponentId(id);
//	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/inward/inwards/all
	@RequestMapping(value = "/displayAll" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public List<InwardResponceDto> getAllInwardsForDisplay() {
		return inwardService.getAllInwardsForDisplay();
	}
	 
	
	@RequestMapping(value = "/dispatchDisplayAll" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public List<DispatchResponceDto> getAllDispatchForDisplay() {
		return inwardService.getAllDispatchForDisplay();
	}
	
	@RequestMapping(value = "/all" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public List<Inward> getAllInwards() {
		return inwardService.getAllInwards();
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/inward
 
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Inward saveInward(@RequestBody Inward inward) { 
		return inwardService.saveInwardDeltails(inward);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/inward/
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE) 
	public void updateInward(@RequestBody Inward inward) { 
		//inward.setCreationDate(CommonUtils.newDateTime().toString()); 
		inwardService.updateInward(inward);
		
	}


	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE) 
	public void removeInwardsEntry(@PathVariable("id") int id) { 
		inwardService.removeInwardsEntry(id);
	}
}

