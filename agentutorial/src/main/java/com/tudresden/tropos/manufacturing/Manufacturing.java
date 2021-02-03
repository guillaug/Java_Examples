package com.tudresden.tropos.manufacturing;
//This is the POJO of the ManufacturerAgent 

import java.io.Serializable;

public class Manufacturing implements Cloneable, Serializable{
	public Manufacturing(String order, String inventory) {
		super();
		this.order = order;
		this.inventory = inventory;
	}
	public String getOrder() {
		return order;
	}
	public String getInventory() {
		return inventory;
	}
	@Override
	public String toString() {
		return "Manufacturing [order=" + order + ", inventory=" + inventory + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		Manufacturing other = (Manufacturing) obj;
		if (inventory == null) {
			if (other.inventory != null)
				return false;
		} else if (!inventory.equals(other.inventory))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}
	private final String order;
	private final String inventory;
	
	public static enum ManufacturingSector{SPAREPART, PHARMACY, MEDICINE, MILITARY, SERVICE};
	
}
