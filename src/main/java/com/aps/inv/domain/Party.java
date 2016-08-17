package com.aps.inv.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity  
@Table(name="party") 
public class Party {

	String partyName;
	 
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int partyId;
	private String partyAddress;
	private String partyPhone; 
	private String partyEmail;
	private String partySupplierCode;
	
	
	@OneToMany(mappedBy="partyId",cascade = CascadeType.ALL)
	private Set<Component> components;
 
}
