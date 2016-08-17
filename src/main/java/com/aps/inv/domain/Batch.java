package com.aps.inv.domain;

public class Batch {
	String furnace,furnaceCapacity;
	String numberOfBatches,personHours;
	public String getFurnace() {
		return furnace;
	}
	public String getFurnaceCapacity() {
		return furnaceCapacity;
	}
	public String getNumberOfBatches() {
		return numberOfBatches;
	}
	public String getPersonHours() {
		return personHours;
	}
	public void setFurnace(String furnace) {
		this.furnace = furnace;
	}
	public void setFurnaceCapacity(String furnaceCapacity) {
		this.furnaceCapacity = furnaceCapacity;
	}
	public void setNumberOfBatches(String numberOfBatches) {
		this.numberOfBatches = numberOfBatches;
	}
	public void setPersonHours(String personHours) {
		this.personHours = personHours;
	}
}
