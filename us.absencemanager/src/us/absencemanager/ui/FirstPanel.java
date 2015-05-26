package us.absencemanager.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FirstPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5182836969988472594L;
	private JButton okBtn;
	private JLabel groupLabel, dateLabel;
	private JComboBox<String> dropDown;
	private JPanel centerPanel;
	
	public FirstPanel() {
		super();
		
		this.setLayout(new BorderLayout());
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2, 2));
		this.add(centerPanel, BorderLayout.CENTER);
		
		
		groupLabel = new JLabel("Choose Group Of Students:");
		centerPanel.add(groupLabel);
		
		dropDown = new JComboBox<String>();
		dropDown.addItem("Add new group...");
		centerPanel.add(dropDown);
		
		dateLabel = new JLabel("Choose date & time:");
		this.add(dateLabel);
		
		okBtn = new JButton("Submit");
		this.add(okBtn, BorderLayout.SOUTH);
		okBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
	}
}
