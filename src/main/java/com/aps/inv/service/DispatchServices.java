package com.aps.inv.service;

import java.util.List;

import com.aps.inv.domain.Dispatched;
 
public interface DispatchServices { 
	 
 
	Dispatched updateDispatch(Dispatched dispatch);
 

	List<Dispatched> getAllDispatches();

	Dispatched saveDispatch(Dispatched dispatch); 

	void removeDispatch(Dispatched dispatch);

	List<Dispatched> getDispatchListByInwardNo(int inno);


	Dispatched getDispatchByDispatchId(int id);

 
	List<Dispatched> getAllDispatchesByInwardId(int inwardNo);
 
}
