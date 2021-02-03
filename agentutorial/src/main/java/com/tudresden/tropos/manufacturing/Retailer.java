package com.tudresden.tropos.manufacturing;

import java.io.Serializable;


//* If a serializable class does not explicitly declare a serialVersionUID, then
//* the serialization runtime will calculate a default serialVersionUID value
//* for that class based on various aspects of the class, as described in the
//* Java(TM) Object Serialization Specification
public class Retailer implements Serializable, Cloneable{

	public Retailer(String name, String retailerIdentificationNumber) {
		this.sector = null;
		this.name = name;
		this.retailerIdentificationNumber = retailerIdentificationNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((retailerIdentificationNumber == null) ? 0 : retailerIdentificationNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retailer other = (Retailer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (retailerIdentificationNumber == null) {
			if (other.retailerIdentificationNumber != null)
				return false;
		} else if (!retailerIdentificationNumber.equals(other.retailerIdentificationNumber))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public String getRetailerIdentificationNumber() {
		return retailerIdentificationNumber;
	}
	private final String name; 
	private final String retailerIdentificationNumber;
	private final Retailer.RetailerSector sector; 
	
	public static enum RetailerSector{SPAREPART, PHARMACY, MEDICINE, MILITARY, SERVICE};
}
