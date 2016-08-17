package com.aps.inv.service;

import java.util.List;

import com.aps.inv.domain.Party;
 
public interface PartyService {
 

	Party getPartyByPartyName(String partyName); 
	Party getPartyByPartyId(int partyId); 
	List<Party> getAllParties(); 
	Party saveParty(Party partyInput); 
	Party updateParty(Party partyInput); 
	void removePartyByPartyId(int partyId);

	 

	 
 
}