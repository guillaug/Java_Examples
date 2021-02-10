package com.tudresden.tropos.manufacturing;


 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class RetailerView extends JFrame{

	  JPanel contentPane;
	  JTextField minHoldingLevel;
	  JTextField maxOrderingLevel;
	  JTextField totalShortage;
//	  JTextField maxSongCount;
	  JComboBox orderType;
	  List console;
	  JButton search;
	  
	  public void addMessageToConsole(String message) {
		  console.add(message);
	  }
	  
	  
	  public RetailerView(RetailerAgent agent) {
		  setResizable(false);
		  addWindowListener(new WindowAdapter() {
			  @Override
			  public void windowClosed(WindowEvent e) {
//				  agent.addBehaviour(agent.new ShutdownAgent());	
			  }
		  });
	  }
	  
	  
}
