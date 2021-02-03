package com.tudresden.jasonframework;
import jason.asSyntax.*;
import jason.environment.*;
import java.util.logging.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;



public class VCWorld extends Environment{

	//world model
	private boolean[][] dirty = {{true, true}, {true, true}};
	
	private int cleanerLocationX = 0; 
	private int cleanerLocationY = 0;
	
	private Object modelLock = new Object(); //lock for synchronization
	
	private HouseGUI gui = new HouseGUI(); 
	private Logger logger = Logger.getLogger("env."+VCWorld.class.getName());
    private Random randomNum = new Random();

	
    /** constant terms used for perception */
    private static final Literal lPos1  = ASSyntax.createLiteral("pos", ASSyntax.createNumber(1));
    private static final Literal lPos2  = ASSyntax.createLiteral("pos", ASSyntax.createNumber(2));
    private static final Literal lPos3  = ASSyntax.createLiteral("pos", ASSyntax.createNumber(3));
    private static final Literal lPos4  = ASSyntax.createLiteral("pos", ASSyntax.createNumber(4));
    private static final Literal lDirty = ASSyntax.createLiteral("dirty");
    private static final Literal lClean = ASSyntax.createLiteral("clean");

	
    /** create the agents perceptions based on the world model */
    private void createPercept() {
        // remove previous perception
        clearPercepts();       
        
        if (cleanerLocationX == 0 && cleanerLocationY == 0) {
            addPercept(lPos1);
        } else if (cleanerLocationX == 1 && cleanerLocationY == 0) {
            addPercept(lPos2);
        } else if (cleanerLocationX == 0 && cleanerLocationY == 1) {
            addPercept(lPos3);
        } else if (cleanerLocationX == 1 && cleanerLocationY == 1) {
            addPercept(lPos4);
        }

        if (dirty[cleanerLocationX][cleanerLocationY]) {
            addPercept(lDirty);
        } else {
            addPercept(lClean);
        }
    }
    
    public VCWorld() {
        createPercept();
        
        // create a thread to add dirty
        new Thread() {
            public void run() {
                try {
                    while (isRunning()) {
                        // add random dirty
                        if (randomNum.nextInt(100) < 20) { 
                            dirty[randomNum.nextInt(2)][randomNum.nextInt(2)] = true;
                            gui.paintRobot();
                            createPercept();
                        }
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {} 
            }
        }.start();  
    }

    @Override
    public boolean executeAction(String ag, Structure action) {
        logger.info("doing "+action);
        
        try { Thread.sleep(500);}  catch (Exception e) {} // slow down the execution
        
        synchronized (modelLock) {
            // Change the world model based on action
            if (action.getFunctor().equals("suck")) {
                if (dirty[cleanerLocationX][cleanerLocationY]) {
                    dirty[cleanerLocationX][cleanerLocationY] = false;
                } else {
                    logger.info("suck in a clean location!");
                    Toolkit.getDefaultToolkit().beep();
                }
            } else if (action.getFunctor().equals("left")) {
                if (cleanerLocationX > 0) {
                	cleanerLocationX--;
                }
            } else if (action.getFunctor().equals("right")) {
                if (cleanerLocationX < 1) {
                	cleanerLocationX++;
                }
            } else if (action.getFunctor().equals("up")) {
                if (cleanerLocationY > 0) {
                	cleanerLocationY--;
                }
            } else if (action.getFunctor().equals("down")) {
                if (cleanerLocationY < 1) {
                	cleanerLocationY++;
                }
            } else {
                logger.info("The action "+action+" is not implemented!");
                return false;
            }
        }
        
        createPercept(); // update agents perception for the new world state      
        gui.paintRobot();
        return true;
    }
	
	
	@Override
	public void stop() {
		super.stop();
		gui.setVisible(false);
	}
	
	class HouseGUI extends JFrame {
		JLabel[][] labels; 
		
		HouseGUI() {
			super("Inner Robot");
			labels = new JLabel[dirty.length][dirty.length];
			getContentPane().setLayout(new GridLayout(labels.length, labels.length));
			for(int j = 0; j < labels.length; j++) {
				for(int i = 0; i < labels.length; i++) {
					labels[i][j] = new JLabel(); 
					labels[i][j].setPreferredSize(new Dimension(180, 180));
					labels[i][j].setHorizontalAlignment(JLabel.CENTER);
					labels[i][j].setBorder(new EtchedBorder());
					getContentPane().add(labels[i][j]); 
				}
			}
			pack(); 
			setVisible(true);
			paintRobot();
		}
		
		void paintRobot() {
			synchronized (modelLock) {
                for (int i = 0; i < labels.length; i++) {
                    for (int j = 0; j < labels.length; j++) {
                        String l = "<html><center>";
                        if (cleanerLocationX == i && cleanerLocationY == j) {
                            l += "<font color=\"red\" size=7><b>Robot</b><br></font>";
                        }
                        if (dirty[i][j]) {
                            l += "<font color=\"blue\" size=6>*kaka*</font>";
                        }
                        l += "</center></html>";
                        labels[i][j].setText(l);
                    }
                }

			}
		}
	}

}

