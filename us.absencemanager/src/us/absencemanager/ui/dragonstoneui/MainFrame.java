package us.absencemanager.ui.dragonstoneui;

import java.awt.BorderLayout;

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
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
