package com.aps.inv.service;

import com.aps.inv.domain.TestCertificate;

public interface TCService {

	TestCertificate getTcByTcNo(int id);
	TestCertificate saveTc(TestCertificate testCertificate);
	TestCertificate updateTc(TestCertificate testCertificate); 
	TestCertificate saveTcWithComponentDetails(int componentId); 

}
