package com.tudresden.jasonframework;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

import jason.environment.grid.GridWorldModel;

public class WorldModel extends GridWorldModel{
	
	protected WorldModel(int w, int h, int nbAgs) {
		super(w, h, nbAgs);
		// TODO Auto-generated constructor stub
	}
	public static final int BLOCK = 32; 
	public static final int TABLE = 64; 
	private Logger logger = Logger.getLogger("BlocksWorld.mas2j." + WorldModel.class.getName());
	
	private String id = "WorldModel"; 
	private List<Stack<String>> stackListWorldModel = new LinkedList<Stack<String>>();
	private String[][] names; 
	
	public static int GHeight = 0; 
	public static int GWidth = 0; 
	
	//singleton pattern
	protected static WorldModel worldModel = null; 
	
	//singleton pattern
	synchronized public static WorldModel create(int w, int h, int nbAgs) {
		if(worldModel == null) {
			worldModel = new WorldModel(w, h, nbAgs);
		}
		return worldModel;
		
	}
	
	public static WorldModel get() {
		return worldModel; 
	}
	
	public static void destroy() {
		worldModel = null; 
	}
	
	public String getId() {
		return id; 
	}
	
	public void setId(String id) {
		this.id = id; 
	}
	
	public String toString() {
		return id; 
	}
	
	public String getName(int x, int y) {
		return names[x][y]; 
	}
	
	public List<Stack<String>> getStacks() {
		return stackList; //fix the issue;
	}
	
	boolean move(String a, String b, List<String> adds, List<String> dels) throws Exception {
		logger.info("Moving action is happening");
		Stack<String> firstStack = null; 
		Stack<String> secondStack = null; 
		
		for(Stack<String> stack : stackListWorldModel) {
			if(stack.peek().equals(a))
				firstStack = stack; 
			if(stack.peek().equals(b))
				secondStack = stack; 
		}
		if(b.equals("table")) {
			secondStack = new Stack<String>();
			secondStack.add("table");
			stackListWorldModel.add(0, secondStack);
		}
		if(firstStack == null || secondStack == null) {
			logger.info("No block on the top of the stack");
			return false; 
		}
		adds.add("on("+firstStack.peek()+"."+secondStack.peek()+")");
		secondStack.push(firstStack.pop());
		
		
		return false;
	}
}
