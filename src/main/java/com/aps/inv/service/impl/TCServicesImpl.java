package com.aps.inv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.inv.domain.TestCertificate;
import com.aps.inv.repository.TCRepository;
import com.aps.inv.service.TCService; 

@Service
public class TCServicesImpl implements TCService{
	
	@Autowired
	private TCRepository tcRepository;
	   
	@Override
	public TestCertificate saveTc(TestCertificate testCertificate) { 
//		if(testCertificate.getTcNo()==0){ 
//		Set<TCGridRow> tcGridRow = testCertificate.getGridRows();
//		testCertificate.setGridRows(null); 
//		TestCertificate savedTc = tcRepository.save(testCertificate);  
//		savedTc.setGridRows(tcGridRow);
//		assignTcNoToTcGridRow(savedTc); 
//		}
//		else{
//			assignTcNoToTcGridRow(testCertificate);
//		}
		return tcRepository.save(testCertificate);
	}

	 
	@Override
	public TestCertificate updateTc(TestCertificate testCertificate) {
//		TestCertificate updatedTc = testCertificate;
//		testCertificate.setGridRows(null);
//		TestCertificate savedTc = tcRepository.save(testCertificate); 
//		updatedTc.setTcNo(savedTc.getTcNo()); 
//		
//		for (TCGridRow tcGridRow:updatedTc.getGridRows()) {
//			tcGridRow.setTcNo(savedTc.getTcNo());
//		}
		return tcRepository.save(testCertificate); 
	}

	@Override
	public TestCertificate getTcByTcNo(int id) {
		return tcRepository.findByTcNo(id); 
	}
//
//	@Override
//	public TestCertificate saveTcWithComponentDetails(int componentId) { 
//		Set<TCGridRow> tcGrid = componentService.getComponentsTcGridById(componentId); 
//		TestCertificate testCertificate = tcRepository.save(new TestCertificate());
//		for (TCGridRow tcRow:tcGrid) {
//			tcRow.setTcNo(testCertificate.getTcNo());
//		}
//		testCertificate.setGridRows(tcGrid);
//		return tcRepository.save(testCertificate); 
//		
//	}
	 
 
	
}
