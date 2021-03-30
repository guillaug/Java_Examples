package com.tudresden.jadeframework;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DistributorGUI extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5478795277393285582L;
	

	private Distributor myAgent;
	
	private JTextField titleField, amountField;
	
	public DistributorGUI(Distributor obj) {
		super(obj.getLocalName()); //get the name of the distributor
		
		myAgent = obj;
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(2, 2));
		jpanel.add(new JLabel("Simulation Software"));
		titleField = new JTextField(15);
		jpanel.add(titleField);
		getContentPane().add(jpanel, BorderLayout.CENTER);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try 
				{
					String title = titleField.getText().trim();
					String price = amountField.getText().trim();
					myAgent.updateWarehouse(title, Integer.parseInt(price));
				} 
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			
		});
		jpanel = new JPanel();
		jpanel.add(addButton);
		getContentPane().add(jpanel, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				myAgent.doDelete();
			}
		});
		
		setResizable(false);
		
	}
	
	public void showGUI() 
	{
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.setVisible(true);
	}
	
	
}
