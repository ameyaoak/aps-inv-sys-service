package com.aps.inv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aps.inv.domain.Party;
import com.aps.inv.domain.TestCertificate;

@Repository
@EnableTransactionManagement
public interface TCRepository extends JpaRepository<TestCertificate, Long> {

	TestCertificate findByTcNo(int id); 
}
