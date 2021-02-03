package com.tudresden.basicagents;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Game {
	public interface Reporter {
		void report(String message, String text);
	}
	private Room currentRoom;
	private final List<Item> inventory = new ArrayList<Item>();
	private final Reporter reporter;
	private final Map<String, Item> itemsByName = new HashMap<String, Item>();
	
	public Game(Reporter reporter) throws Exception {
		this.reporter = reporter;

		// read the room description
		Model model = defineModel();

		// set up the item index
		for(Item item : model.getItems()) {
			itemsByName.put(item.getName(), item);
		}
		currentRoom = model.getStartRoom();

		look();
	}
	
	public boolean report(String command, String message) {
		reporter.report(message, "Command: " + command + "\n\n" + message);
		return false;
	}
	
	public boolean get(String itemName) {
		String command = "get " + itemName;
		Item item = itemsByName.get(itemName);
		if (item == null) {
			return report(command, "You don't see the " + itemName + " in the room");
		}
		
		if (inventory.contains(item))
			return report(command, "You already have the " + itemName);

		if (!currentRoom.getContents().contains(item)) {
			return report(command, "You don't see the " + itemName + " in the room");
		}

		if (!item.isCarryable())
			return report(command, "You can't pick up the " + itemName);

		currentRoom.getContents().remove(item);
		inventory.add(item);
		return report(command, "You picked up the " + itemName);
	}
	
	public boolean drop(String itemName) {
		String command = "drop " + itemName;
		Item item = itemsByName.get(itemName);
		if (item == null || !inventory.contains(item)) {
			return report(command, "You don't have the " + itemName);
		}
		
		inventory.remove(item);
		currentRoom.getContents().add(item);
		
		return report(command, "You dropped the " + itemName);
	}

	public boolean getFrom(String itemName, String containerName) {
		String command = "get " + itemName + " from " + containerName;
		Item container = itemsByName.get(containerName);
		if (container == null || (!currentRoom.getContents().contains(container) && !inventory.contains(container))) {
			return report(command, "You don't see the " + containerName + " in the room or your inventory");
		}
		if (!container.isContainer()) {
			return report(command, "The " + containerName + " cannot contain anything");
		}

		if (!container.isOpen()) {
			return report(command, "The " + containerName + " is not open and you cannot see inside it");
		}

		Item item = itemsByName.get(itemName);
		if (item == null || !container.getContents().contains(item)) {
			return report(command, "You don't see the " + itemName + " in the " + containerName);
		}
		
		container.getContents().remove(item);
		inventory.add(item);
		return report(command, "You got the " + itemName + " from the " + containerName);
	}
	
	public boolean open(String containerName) {
		String command = "open " + containerName;
		Item container = itemsByName.get(containerName);
		if (container == null || (!currentRoom.getContents().contains(container) && !inventory.contains(container))) {
			return report(command, "You don't see the " + containerName + " in the room or your inventory");
		}
		if (!container.isContainer()) {
			return report(command, "The " + containerName + " cannot contain anything so it cannot be opened");
		}
		
		if (container.isOpen()) {
			return report(command, "The " + containerName + " is already open");
		}
		if (container.isLocked()) {
			return report(command, "The " + containerName + " is locked");
		}

		container.open(true);
		return report(command, "You opened the " + containerName);
	}
	
	public boolean close(String containerName) {
		String command = "close " + containerName;
		Item container = itemsByName.get(containerName);
		if (container == null || (!currentRoom.getContents().contains(container) && !inventory.contains(container))) {
			return report(command, "You don't see the " + containerName + " in the room or your inventory");
		}
		if (!container.isContainer()) {
			return report(command, "The " + containerName + " cannot contain anything so it cannot be closed");
		}
		
		if (container.isOpen()) {
			return report(command, "The " + containerName + " is already closed");
		}

		container.open(false);
		return report(command, "You closed the " + containerName);
	}
	
	public boolean unlock(String containerName) {
		String command = "unlock " + containerName;
		Item container = itemsByName.get(containerName);
		if (container == null || (!currentRoom.getContents().contains(container) && !inventory.contains(container))) {
			return report(command, "You don't see the " + containerName + " in the room or your inventory");
		}
		if (container.getKey() == null) {
			return report(command, "The " + containerName + " does not have a lock");
		}
		
		if (container.isOpen()) {
			return report(command, "The " + containerName + " must be closed to be unlocked");
		}
		if (!inventory.contains(container.getKey())) {
			return report(command, "You do not have the key for the " + containerName);
		}
		
		container.locked(false);
		return report(command, "You unlocked the " + containerName);
	}

	public boolean lock(String containerName) {
		String command = "lock " + containerName;
		Item container = itemsByName.get(containerName);
		if (container == null || (!currentRoom.getContents().contains(container) && !inventory.contains(container))) {
			return report(command, "You don't see the " + containerName + " in the room or your inventory");
		}
		if (container.getKey() == null) {
			return report(command, "The " + containerName + " does not have a lock");
		}
		
		if (container.isOpen()) {
			return report(command, "The " + containerName + " must be closed to be locked");
		}
		if (!inventory.contains(container.getKey())) {
			return report(command, "You do not have the key for the " + containerName);
		}
		
		container.locked(true);
		return report(command, "You locked the " + containerName);
	}

	public boolean examine(String itemName) {
		String command = "examine " + itemName;
		Item item = itemsByName.get(itemName);
		if (item == null) {
			return report(command, "You don't see the " + itemName + " in the room");
		}
		
		if (!inventory.contains(item) && !currentRoom.getContents().contains(item)) {
			return report(command, "You don't see the " + itemName + " in the room or your inventory");
		}

		return report(command, getDescription(item));
	}
	
	public boolean look() {
		return report("look", getDescription());
	}
	
	public boolean inventory() {
		return report("inventory", dumpContents("inventory", inventory));
	}
	
	public boolean go(Direction direction) {
		Room nextRoom = null;
		for(Exit exit : currentRoom.getExits()) {
			if (exit.getDirection() == direction) {
				nextRoom = exit.getTo();
			}
		}
		if (nextRoom == null) {
			String dir = direction.name().toLowerCase();
			return report("go " + dir, "You cannot go " + dir);
		}
		currentRoom = nextRoom;
		return look();
	}
	
	
	private String getDescription() {
		String result = currentRoom.getDescription();
		if (!currentRoom.getExits().isEmpty()) {
			result += "\n\n" + "You can go ";
			for(Exit exit : currentRoom.getExits()) {
				result += exit.getDirection().name() + ", ";
			}
			result = result.substring(0, result.length()-2);
		}
		if (!currentRoom.getContents().isEmpty()) {
			result += "\n\n" + "You see ";
			for (Item item : currentRoom.getContents()) {
				result += "a " + item.getName() + ", ";
			}
			result = result.substring(0, result.length()-2);
		}
		return result;
	}

	public Room move(Room room, Direction direction) {
		for(Exit exit : room.getExits()) {
			if (exit.getDirection() == direction) {
				return exit.getTo();
			}
		}
		return null;
	}	
	
	
	public String getDescription(Item item) {
		String result = item.getDescription();
		if (item.isContainer()) {
			if (item.isLocked()) {
				return result + "\n\n The " + item.getName() + " is locked";
			}
			if (!item.isOpen()) {
				return result + "\n\n The " + item.getName() + " is closed";
			}
			result += "\n\n" + dumpContents(item.getName(), item.getContents());
		}
		return result;
	}

	
	public String dumpContents(String containerName, List<Item> items) {
		String article = "The ";
		if ("inventory".equals(containerName))
			article = "Your ";
		if (items.isEmpty())
			return article + containerName + " is empty";
		String result = article + containerName + " contains ";
		for (Item item : items) {
			result += "a " + item.getName() + ", ";
		}
		result = result.substring(0, result.length()-2);
		return result;
	}

	private Model defineModel() throws Exception {
		try {
			Model model = new Model();
			String json = FileUtils.readFileToString(new File("adventure.json"), Charset.forName("UTF-8"));

			Map<String, Room> rooms = new HashMap<String, Room>();
			Map<String, Item> items = new HashMap<String, Item>();
			Map<Item, String> keyFor = new IdentityHashMap<Item, String>();
			Map<Object, JSONArray> contentsFor = new IdentityHashMap<Object, JSONArray>();
			Map<Room, JSONArray> exitsFor = new IdentityHashMap<Room, JSONArray>();
			
			JSONObject jsonObject = new JSONObject(json);
			
			JSONArray itemsArray = jsonObject.getJSONArray("items");
			JSONArray roomsArray = jsonObject.getJSONArray("rooms");
			String startRoom = jsonObject.getString("startRoom");
			
			for (Object itemObject : itemsArray) {
				JSONObject jsonItem = (JSONObject) itemObject;
				
				Item item = new Item()
						.name(jsonItem.getString("name"))
						.description(jsonItem.getString("description"))
						.carryable(jsonItem.optBoolean("carryable", false))
						.container(jsonItem.optBoolean("container", false))
						.locked(jsonItem.optBoolean("locked", false))
						.open(jsonItem.optBoolean("open", false));
						
				items.put(item.getName(), item);
				String keyName = jsonItem.optString("key", null);
				if (keyName != null) {
					keyFor.put(item, keyName);
				}
				
				JSONArray contentNames = jsonItem.optJSONArray("contents");
				if (contentNames != null && contentNames.length() > 0) {
					contentsFor.put(item, contentNames);
				}
			}

			// resolve the keys and contents
			for(Item item : items.values()) {
				model.add(item);
				String keyName = keyFor.get(item);
				if (keyName != null) {
					item.key(items.get(keyName));
				}
				JSONArray contentNames = contentsFor.get(item);
				if (contentNames != null) {
					for(Object o : contentNames) {
						item.add(items.get((String)o));
					}
				}
			}

			for (Object roomObject : roomsArray) {
				JSONObject jsonRoom = (JSONObject) roomObject;

				Room room = new Room()
						.name(jsonRoom.getString("name"))
						.description(jsonRoom.getString("description"));
				
				rooms.put(room.getName(), room);
				
				JSONArray exits = jsonRoom.optJSONArray("exits");
				if (exits != null && exits.length() > 0) {
					exitsFor.put(room, exits);
				}

				JSONArray contents = jsonRoom.optJSONArray("contents");
				if (contents != null && contents.length() > 0) {
					contentsFor.put(room, contents);
				}
			}

			// resolve the exits and room contents
			for(Room room : rooms.values()) {
				model.add(room);
				JSONArray exits = exitsFor.get(room);
				if (exits != null) {
					for(Object o : exits) {
						JSONObject exit = (JSONObject) o;
						String directionName = exit.getString("direction");
						String to = exit.getString("to");
						room.add(new Exit()
								.direction(Direction.valueOf(directionName.toUpperCase()))
								.to(rooms.get(to)));
					}
				}
				JSONArray contentNames = contentsFor.get(room);
				if (contentNames != null) {
					for(Object o : contentNames) {
						room.add(items.get((String)o));
					}
				}
			}
			model.startRoom(rooms.get(startRoom));
			
			return model;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
