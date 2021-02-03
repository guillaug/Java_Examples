package com.tudresden.basicagents;

public class Exit {
	private Direction direction;
	private Room to;

	public Exit() {}
	public Exit(Direction direction, Room to) {
		this.direction = direction;
		this.to = to;
	}
	public Direction getDirection() {
		return direction;
	}
	public Exit direction(Direction direction) {
		this.direction = direction;
		return this;
	}
	public Room getTo() {
		return to;
	}
	public Exit to(Room to) {
		this.to = to;
		return this;
	}
}

