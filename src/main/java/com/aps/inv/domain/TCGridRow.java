package com.aps.inv.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tcgridrow") 
public class TCGridRow { 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int gridRowId;
	private int tcNo;
	private String actuals,testLocation,testMethod,qty,particular,observation,remark,checkedBy; 
}
