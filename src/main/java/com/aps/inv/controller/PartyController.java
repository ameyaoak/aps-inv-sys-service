package com.aps.inv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aps.inv.domain.Party;
import com.aps.inv.service.PartyService;
 
@RestController
@RequestMapping("/party")
public class PartyController {

	@Autowired
	PartyService partyServices;

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/party/1
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Party getPartyByPartyId(@PathVariable("id") int id) { 
		return partyServices.getPartyByPartyId(id);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/party/name/eg
	@RequestMapping(value = "/name/{partyName}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Party getPartyByPartyName(@PathVariable("partyName") String partyName) { 
		return partyServices.getPartyByPartyName(partyName);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/party/parties/all
	@RequestMapping(value = "/all" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public List<Party> getAllParties() {
		return partyServices.getAllParties();
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/party
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Party saveParty(@RequestBody Party partyInput) { 
		return partyServices.saveParty(partyInput);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/party/updateParty/1
	@RequestMapping(value = "/{id}" , method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Party updateParty(@RequestBody Party partyInput) { 
		return partyServices.updateParty(partyInput);
	}


	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE) 
	public void removePartyByPartyId(@PathVariable("partyId") int id) { 
		partyServices.removePartyByPartyId(id);
	}
}

