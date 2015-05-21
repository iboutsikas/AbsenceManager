package us.frontendmanager;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8838248803600923866L;
	private final int WIDTH = 800 , HEIGHT = 600;
	private FirstPanel fPanel;
	
	public MainFrame(){
		super();
		
		Container mainContainer = getContentPane();
		mainContainer.setLayout(new BorderLayout());
		
		fPanel = new FirstPanel();
		mainContainer.add(fPanel, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("City College Absense System");
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		
	}
	
	private void populateDropDown(){
		//TODO fetch StudentGroup name <String>
	}
}
