package com.aps.inv.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aps.inv.domain.Dispatched;
import com.aps.inv.service.DispatchServices;
 

@RestController
@RequestMapping("/dispatch")
public class DispatchController {

	@Autowired
	DispatchServices dispatchServices;

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/dispatch/1
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Dispatched getDispatchByDispatchId(@PathVariable("id") int id) { 
		return dispatchServices.getDispatchByDispatchId(id);
	}
 

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/dispatch/dispatches/all
	@RequestMapping(value = "/all" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public List<Dispatched> getAllDispatches() {
		return dispatchServices.getAllDispatches();
	}
	
	@RequestMapping(value = "/all/dispatches/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public List<Dispatched> getAllDispatchesByInwardId(@PathVariable("id") int id) {
		return dispatchServices.getAllDispatchesByInwardId(id);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/dispatch
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)  
		public Dispatched saveDispatch(@RequestBody Dispatched dispatch) { 
		return dispatchServices.saveDispatch(dispatch);
	}

	//http://localhost:8080/Jersey-Spring-Hibernate/rest/dispatch/1
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)  
	public Dispatched updateInvoice(@PathVariable("id") String id,@RequestBody Dispatched dispatch) {  
		return dispatchServices.updateDispatch(dispatch);
	}


	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)  
	public void removeInvoice(@PathParam("id") int id) { 
		Dispatched dispatch = dispatchServices.getDispatchByDispatchId(id);
		dispatchServices.removeDispatch(dispatch);
	}
}

