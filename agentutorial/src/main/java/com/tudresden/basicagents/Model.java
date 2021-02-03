package com.tudresden.basicagents;

import java.util.ArrayList;
import java.util.List;

public class Model {
	private List<Item> items = new ArrayList<Item>();
	private List<Room> rooms = new ArrayList<Room>();
	private Room startRoom;
	
	
	public Model() {}
	public Model(Room startRoom, Object... itemsAndRooms) {
		super();
		this.startRoom = startRoom;
		for(Object o : itemsAndRooms) {
			if (o instanceof Item) {
				this.items.add((Item)o);
			} else if (o instanceof Room) {
				this.rooms.add((Room)o);
			} else {
				throw new IllegalArgumentException();
			}
		}
	}
	public List<Item> getItems() {
		return items;
	}
	public Model add(Item item) {
		this.items.add(item);
		return this;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public Model add(Room room) {
		this.rooms.add(room);
		return this;
	}
	public Room getStartRoom() {
		return startRoom;
	}
	public Model startRoom(Room startRoom) {
		this.startRoom = startRoom;
		return this;
	}
}
