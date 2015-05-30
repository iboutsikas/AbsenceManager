package us.absencemanager.ui.ad;

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
	private JLabel groupLabel, timeLabel, hourLb, minLb;
	private JComboBox<String> dropDownGroup;
	private JPanel centerPanel, timePanel;
	private JSpinner hour, min;
	
	public FirstPanel() {
		super();
		this.setBorder(BorderFactory.createEmptyBorder(10, 1, 1, 1));
		this.setLayout(new BorderLayout());
		
		this.createCenterPanel();
		this.add(centerPanel, BorderLayout.CENTER);
	}
	
	public void createCenterPanel(){
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2, 2));
		
		groupLabel = new JLabel("Choose Group Of Students:");
		groupLabel.setVerticalAlignment(JLabel.BOTTOM);
		centerPanel.add(groupLabel);
		
		dropDownGroup = new JComboBox<String>();
		dropDownGroup.addItem("Add new group...");
		centerPanel.add(dropDownGroup);
		
		timeLabel = new JLabel("Choose time:");
		timeLabel.setVerticalAlignment(JLabel.BOTTOM);
		centerPanel.add(timeLabel);
		
		timePanel = new JPanel();
		timePanel.setLayout(new FlowLayout());
		hourLb = new JLabel("Hour:");
		minLb  =new JLabel("Minutes:");
		hour = new JSpinner();
		min = new JSpinner();
		timePanel.add(hourLb);
		timePanel.add(hour);
		timePanel.add(minLb);
		timePanel.add(min);
		centerPanel.add(timePanel);
	}
	
	public void populateList(String item){
		dropDownGroup.addItem(item);
	}
}