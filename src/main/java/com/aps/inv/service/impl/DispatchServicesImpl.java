package com.aps.inv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.inv.domain.Dispatched;
import com.aps.inv.repository.DispatchRepository;
import com.aps.inv.service.DispatchServices; 

@Service
public class DispatchServicesImpl implements DispatchServices{
	
	@Autowired
	private DispatchRepository dispatchedRepository; 

	@Override
	public List<Dispatched> getDispatchListByInwardNo(int inno) { 
		return dispatchedRepository.findByInwardNo(inno);
	} 
	
	@Override
	public Dispatched updateDispatch(Dispatched dispatch) {
		return dispatchedRepository.save(dispatch);
	}

	@Override
	public Dispatched getDispatchByDispatchId(int id) {
		return dispatchedRepository.findByDispatchNo(id); 
	}

	@Override
	public List<Dispatched> getAllDispatches() { 
		return dispatchedRepository.findAll();
	}
	 

	@Override
	public Dispatched saveDispatch(Dispatched dispatch) { 
		return dispatchedRepository.save(dispatch);
	}

	@Override
	public void removeDispatch(Dispatched dispatch) {
		dispatchedRepository.delete(dispatch);
	}

	@Override
	public List<Dispatched> getAllDispatchesByInwardId(int inwardNo) {
		dispatchedRepository.findByInwardNo(inwardNo);
		return null;
	}
}
