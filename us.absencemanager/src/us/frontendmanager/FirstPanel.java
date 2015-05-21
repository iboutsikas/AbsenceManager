package us.frontendmanager;

import java.awt.*;

import javax.swing.*;

public class FirstPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5182836969988472594L;
	private JButton okBtn;
	private JLabel msgLabel;
	private JComboBox<String> dropDown;
	private JPanel centerPanel;
	
	public FirstPanel() {
		super();
		
		this.setLayout(new BorderLayout());
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0, 2));
		this.add(centerPanel, BorderLayout.CENTER);
		
		
		msgLabel = new JLabel("Choose Group Of Students:");
		centerPanel.add(msgLabel);
		
		dropDown = new JComboBox<String>();
		dropDown.addItem("Add new group...");
		centerPanel.add(dropDown);
		
		
		
		okBtn = new JButton("Submit");
		this.add(okBtn, BorderLayout.SOUTH);
		
		
	}
}
