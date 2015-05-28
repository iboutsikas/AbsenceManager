package us.absencemanager.ui.dragonstoneui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	private ControlPanel controlPanel;
	private JTextArea textArea;
	
	public MainFrame() {
		controlPanel = new ControlPanel();
		textArea = new JTextArea("", 15, 1);
		
		
		
		add(controlPanel, BorderLayout.WEST);
		add(textArea, BorderLayout.CENTER);
		
		setTitle("Absence Manager");
		setIconImage(null);
		setPreferredSize(new Dimension(600, 500));
		setSize(new Dimension(600, 500));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
