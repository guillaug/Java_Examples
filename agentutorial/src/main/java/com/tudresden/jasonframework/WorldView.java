package com.tudresden.jasonframework;

import java.util.logging.Logger;

import jason.environment.grid.GridWorldModel;
import jason.environment.grid.GridWorldView;

import java.awt.Color;
import java.awt.Graphics;

public class WorldView extends GridWorldView{
	
	public static final int BLOCK = 32; 
	public static final int TABLE = 64; 
	private Logger logger = Logger.getLogger("BlocksWorlds.mas2j" + WorldView.class.getName());
	
	public WorldView (GridWorldModel model) {
		super(model, "Blocks World", 600); 
		setVisible(true);
		repaint();
	}
	
	@Override
	public void draw(Graphics g, int x, int y, int object) {
		switch(object) {
		case WorldModel.BLOCK: 
			drawBlock(g, x, y);
		}
	}
	
	public void drawBlock(Graphics graphics, int x, int y) {
		graphics.setColor(Color.red);
		graphics.fillRect(x * cellSizeW, y * cellSizeH, cellSizeW, cellSizeH);
		graphics.setColor(Color.black);
		graphics.drawRect(x * cellSizeW + 2, y * cellSizeH + 2, cellSizeW - 4, cellSizeH - 4);
		drawString(graphics, x, y, defaultFont, ((GridWorldModel)getModel()).getName(x,y));
	}
	
	public void drawTable(Graphics graphics, int x, int y) {
		graphics.setColor(Color.green);
		graphics.fillRect(x * cellSizeW, y * cellSizeH, cellSizeW, cellSizeH);
	}
}
