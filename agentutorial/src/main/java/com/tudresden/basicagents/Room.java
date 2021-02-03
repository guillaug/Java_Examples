package com.tudresden.basicagents;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private String name;
	private String description;
	private List<Item> contents = new ArrayList<Item>();
	private List<Exit> exits = new ArrayList<Exit>();
	
	public Room() {}
	
	public Room(String name, String description, Item... contents) {
		super();
		this.name = name;
		this.description = description;
		for(Item item : contents) {
			this.contents.add(item);
		}
	}
	public String getName() {
		return name;
	}
	public Room name(String name) {
		this.name = name;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public Room description(String description) {
		this.description = description;
		return this;
	}
	public List<Item> getContents() {
		return contents;
	}
	public Room add(Item item) {
		this.contents.add(item);
		return this;
	}
	public List<Exit> getExits() {
		return exits;
	}
	public Room add(Exit exit) {
		this.exits.add(exit);
		return this;
	}
}
