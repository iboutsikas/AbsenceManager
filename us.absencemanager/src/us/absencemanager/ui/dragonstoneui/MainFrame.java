package us.absencemanager.ui.dragonstoneui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
	private ControlPanel controlPanel;
	private TablePanel tablePanel;
	private JPanel leftPane;
	private ExistingStudentPanel existingStudentPanel;
	
	public MainFrame() {
		controlPanel = new ControlPanel();
		tablePanel = new TablePanel();
		existingStudentPanel = new ExistingStudentPanel();
		leftPane = new JPanel(new GridLayout(2, 1));
		
		
		leftPane.add(controlPanel);
		leftPane.add(existingStudentPanel);
		
		add(leftPane, BorderLayout.WEST);
		add(tablePanel, BorderLayout.CENTER);
		
		setTitle("Absence Manager");
		setIconImage(null);
		setPreferredSize(new Dimension(800, 600));
		setSize(new Dimension(800, 600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
