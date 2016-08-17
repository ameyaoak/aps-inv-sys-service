package com.aps.inv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.inv.domain.Party;
import com.aps.inv.repository.PartyRepository;
import com.aps.inv.service.PartyService;
 
@Service
public class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyRepository partyRepository; 


	@Override
	public void removePartyByPartyId(int partyId) { 
		 partyRepository.deleteByPartyId(partyId);
	}

	@Override
	public Party getPartyByPartyName(String partyName) {
		return partyRepository.findByPartyName(partyName);
	}

	@Override
	public Party getPartyByPartyId(int partyId) { 
		return partyRepository.findByPartyId(partyId);
	}

	@Override
	public List<Party> getAllParties() { 
		return partyRepository.findAll();
	}

	@Override
	public Party saveParty(Party partyInput) {
		return partyRepository.save(partyInput); 
	} 

	@Override
	public Party updateParty(Party partyInput) {  
		return partyRepository.save(partyInput); 
	}

 

}