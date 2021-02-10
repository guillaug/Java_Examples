package com.tudresden.tropos.manufacturing;

import java.awt.List;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.tudresden.multiagents.distributors.Manufacturer;

import jade.core.behaviours.Behaviour;



public class UIMaker extends JFrame{

	JPanel contentPanel; 
	JTextField txtItemName; 
	JTextField txtOrderingLevel; 
	JTextField txtShortageLevel; 
	JComboBox txtItemType; //Hitech, Agriculture, Pharmacy, Military, Automotive
	List lstOrdered;
	DefaultListModel lstOrderedList;
	
	public UIMaker(final Manufacturer agent) {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e)
			{
				//Terminate the agent state when the window was closed.
//				agent.addBehaviour(agent.new ShutdownAgent());
			}
		});
		
		setTitle("Provider: " + agent.getLocalName());
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setBounds(100, 100, 618, 416);
	    contentPanel = new JPanel();
	    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPanel);
	    contentPanel.setLayout(null);

	}
	
	
}
