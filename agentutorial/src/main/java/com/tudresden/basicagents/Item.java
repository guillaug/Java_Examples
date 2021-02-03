package com.tudresden.basicagents;

import java.util.ArrayList;
import java.util.List;

public class Item {
	private boolean carryable;
	private String name;
	private String description;
	private Item key;
	private boolean locked;
	private boolean open;
	private boolean container;
	private List<Item> contents = new ArrayList<Item>();
	
	public Item() {}
	
	public Item(String name, String description, boolean carryable) {
		super();
		this.name = name;
		this.description = description;
		this.carryable = carryable;
		this.container = false;
	}

	public Item(String name, String description, boolean carryable, Item key, boolean locked, boolean open, Item... items) {
		super();
		this.name = name;
		this.description = description;
		this.carryable = carryable;
		this.key = key;
		this.container = true;
		this.locked = locked;
		this.open = open;
		for(Item item : items) {
			this.contents.add(item);
		}
	}
	public boolean isCarryable() {
		return carryable;
	}
	public Item carryable(boolean carryable) {
		this.carryable = carryable;
		return this;
	}
	public String getName() {
		return name;
	}
	public Item name(String name) {
		this.name = name;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public Item description(String description) {
		this.description = description;
		return this;
	}
	public Item getKey() {
		return key;
	}
	public Item key(Item key) {
		this.key = key;
		return this;
	}
	public boolean isLocked() {
		return locked;
	}
	public Item locked(boolean locked) {
		this.locked = locked;
		return this;
	}
	public boolean isOpen() {
		return open;
	}
	public Item open(boolean open) {
		this.open = open;
		return this;
	}
	public boolean isContainer() {
		return container;
	}
	public Item container(boolean container) {
		this.container = container;
		return this;
	}
	public List<Item> getContents() {
		return contents;
	}
	public Item add(Item item) {
		this.contents.add(item);
		return this;
	}
}
