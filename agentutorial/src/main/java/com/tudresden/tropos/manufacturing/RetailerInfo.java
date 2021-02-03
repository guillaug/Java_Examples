package com.tudresden.tropos.manufacturing;

import java.io.Serializable;

public class RetailerInfo implements Cloneable, Serializable{

	public RetailerInfo(double ordering, double holding, double shortage) {
		super();
		this.ordering = ordering;
		this.holding = holding;
		this.shortage = shortage;
	}
	public double getOrdering() {
		return ordering;
	}
	public void setOrdering(double ordering) {
		this.ordering = ordering;
	}
	public double getHolding() {
		return holding;
	}
	public void setHolding(double holding) {
		this.holding = holding;
	}
	public double getShortage() {
		return shortage;
	}
	public void setShortage(double shortage) {
		this.shortage = shortage;
	}
	@Override
	public String toString() {
		return "Retailer [ordering=" + ordering + ", holding=" + holding + ", shortage=" + shortage + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(holding);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ordering);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(shortage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		RetailerInfo other = (RetailerInfo) obj;
		if (Double.doubleToLongBits(holding) != Double.doubleToLongBits(other.holding))
			return false;
		if (Double.doubleToLongBits(ordering) != Double.doubleToLongBits(other.ordering))
			return false;
		if (Double.doubleToLongBits(shortage) != Double.doubleToLongBits(other.shortage))
			return false;
		return true;
	}
	
	@Override
	public RetailerInfo clone() {
		return new RetailerInfo(this.getHolding(), this.getOrdering(), this.getShortage());
	}

	private double ordering; 
	private double holding; 
	private double shortage; 
}
