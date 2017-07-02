package com.aps.inv.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "inward")
public class Inward {

	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="InwardSeq")
	@SequenceGenerator(
		name="InwardSeq",
		sequenceName="INWARD_SEQ",
		allocationSize=1,
		initialValue=0
	) 
	private int inwardNo;

	@OneToOne
	@JoinColumn(name = "componentId")
	private Component component;
	private double qtyKgs, qtyNos, total;
	private Date creationDate = new Date();

	@OneToMany(mappedBy = "inwardNo", cascade = CascadeType.ALL)
	private Set<Dispatched> dispatches;

	private String inspectedQty, damageQty, inspectedDistortation, finish, checkedBy, remark, partyDc, partyDate, poNo,
			poDate;
}
