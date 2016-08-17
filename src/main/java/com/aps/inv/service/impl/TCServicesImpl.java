package com.aps.inv.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.inv.domain.MicroGridRow;
import com.aps.inv.domain.TCGridRow;
import com.aps.inv.domain.TestCertificate;
import com.aps.inv.repository.TCRepository;
import com.aps.inv.repository.TcGridRowRepository;
import com.aps.inv.service.ComponentService;
import com.aps.inv.service.TCService; 

@Service
public class TCServicesImpl implements TCService{
	
	@Autowired
	private TCRepository tcRepository;
	
	@Autowired
	private TcGridRowRepository tcGridRowRepository;
	
	@Autowired
	private ComponentService componentService;

	@Override
	public TestCertificate getTcByTcNo(int id,int componentId) {
		Set<TCGridRow> tcGrid = componentService.getComponentsTcGridById(componentId);
		MicroGridRow microGrid = componentService.getComponentsMicroGridById(componentId);
		TestCertificate testCertificate = new TestCertificate();
		testCertificate.setGridRows(tcGrid);
		testCertificate.setCut(microGrid.getCut());
		testCertificate.setHv(microGrid.getHv());
		testCertificate.setLoadVal(microGrid.getLoad());
		testCertificate.setMm(microGrid.getMm());
		return tcRepository.findByTcNo(id); 
	}
 
	@Override
	public TestCertificate saveTc(TestCertificate testCertificate) { 
		if(testCertificate.getTcNo()==0){ 
		Set<TCGridRow> tcGridRow = testCertificate.getGridRows();
		testCertificate.setGridRows(null); 
		TestCertificate savedTc = tcRepository.save(testCertificate);  
		savedTc.setGridRows(tcGridRow);
		assignTcNoToTcGridRow(savedTc); 
		}
		else{
			assignTcNoToTcGridRow(testCertificate);
		}
		return tcRepository.save(testCertificate);
	}

	private void assignTcNoToTcGridRow(TestCertificate testCertificate) {
		Set<TCGridRow> gridRows = testCertificate.getGridRows();
		for (TCGridRow tcGridRow:gridRows) {
			tcGridRow.setTcNo(testCertificate.getTcNo());
		}
		
	}

	@Override
	public TestCertificate updateTc(TestCertificate testCertificate) {
		TestCertificate updatedTc = testCertificate;
		testCertificate.setGridRows(null);
		TestCertificate savedTc = tcRepository.save(testCertificate); 
		updatedTc.setTcNo(savedTc.getTcNo()); 
		
		for (TCGridRow tcGridRow:updatedTc.getGridRows()) {
			tcGridRow.setTcNo(savedTc.getTcNo());
		}
		return tcRepository.save(updatedTc); 
	}

	@Override
	public TestCertificate getTcByTcNo(int id) {
		return tcRepository.findByTcNo(id); 
	}
	 
 
	
}
