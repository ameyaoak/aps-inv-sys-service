package com.aps.inv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aps.inv.domain.Party;

@Repository
@EnableTransactionManagement
public interface PartyRepository extends JpaRepository<Party, Long> {

	Party findByPartyId(int partyId);
 
	Party findByPartyName(String partyName);

	void deleteByPartyId(int partyId);

}
