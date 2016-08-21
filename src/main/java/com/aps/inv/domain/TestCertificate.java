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
@Table(name="testcertificate") 
public class TestCertificate {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tcNo; 
	
	@OneToMany(mappedBy="tcNo",cascade = CascadeType.ALL)
	private Set<TCGridRow> gridRows; 
	
	String mm,cut,hv,loadVal;
	
	String refStd,heatCode,batchNo,furnace,finalDisposition;
	
	String carbonActualCP,carbonActualTime,carbonDiff,carbonDiffCP,carbonDiffTime,hardneningTemp,
    hardneningCP,hardneningTime;
	
	String temperingQOTBefore,temperingQOTAfter,temperingT1Temp,temperingT1Time,temperingT2Temp,
	temperingT2Time;
	
	String annTemp,annTime,normTemp,normTime,totalBatchTime;
	 
}
