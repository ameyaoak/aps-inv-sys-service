package com.aps.inv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aps.inv.domain.TestCertificate;
import com.aps.inv.service.TCService;
 

@RestController
@RequestMapping("/tc")
public class TCController {

	@Autowired
	TCService tcService;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public TestCertificate getTcByTcNo(@PathVariable("id") int id) { 
		return tcService.getTcByTcNo(id);
	}
 
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) 
	public TestCertificate saveTc(@RequestBody TestCertificate testCertificate) { 
		return tcService.saveTc(testCertificate);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE) 
	public TestCertificate updateTc(@RequestBody TestCertificate testCertificate) { 
		return tcService.updateTc(testCertificate);
	}
}

