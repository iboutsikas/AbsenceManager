package us.absencemanager.ui.dragonstoneui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel {
	private JComboBox groupSelectionBox;
	private JLabel groupSelectionLabel;
	private JComboBox unitSelectionBox;
	private JLabel unitSelectionLabel;
	private JLabel classroomLabel;
	private JTextField classroomText;
	private JSpinner dateSpinner;
	private JLabel dateLabel;
	private JSpinner timeSpinner;
	private JLabel timeLabel;
	private JButton loadButton;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ControlPanel() {
		groupSelectionBox = new JComboBox(new String[] {"Group 1", "Group 2", "Group 3"});
		groupSelectionLabel = new JLabel("Select group:");
		unitSelectionBox = new JComboBox(new String[] {"Object Oriented Programing", "System Analysis and Design", "Network Architectures"});
		unitSelectionLabel = new JLabel("Select unit:");
		classroomText = new JTextField(5);
		classroomLabel = new JLabel("Select classroom:");
		dateSpinner = new JSpinner();
		dateLabel = new JLabel("Select date:");
		timeSpinner = new JSpinner();
		timeLabel = new JLabel("Select time:");
		loadButton = new JButton("Fetch");
		
		
		
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(350, 250));
		Border titledBorder = BorderFactory.createTitledBorder("Controls");
		Border spaceBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		setBorder(BorderFactory.createCompoundBorder(spaceBorder, titledBorder));
		GridBagConstraints gc = new GridBagConstraints();
		Insets controlInset = new Insets(0, 10, 0, 10);
		Insets labelInset = new Insets(0, 10, 0, 0);
		///// First row ////
		gc.gridy = 0;
		gc.gridx = 0;
		gc.weightx = 1;
		gc.weighty = 0.02;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = labelInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(groupSelectionLabel, gc);
		
		gc.gridx = 1;
		gc.insets = controlInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(groupSelectionBox, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = labelInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(unitSelectionLabel, gc);
		
		gc.gridx = 1;
		gc.insets = controlInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(unitSelectionBox, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = labelInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(classroomLabel, gc);
		
		gc.gridx = 1;
		gc.insets = controlInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(classroomText, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = labelInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(dateLabel, gc);
		
		gc.gridx = 1;
		gc.insets = controlInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(dateSpinner, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = labelInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(timeLabel, gc);
			
		gc.gridx = 1;
		gc.insets = controlInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(timeSpinner, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 1;
		gc.weighty = 0.08;
		gc.anchor = GridBagConstraints.LINE_START;
		add(loadButton, gc);
	}
}
