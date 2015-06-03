package us.absencemanager.ui.ad;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import us.absencemanager.controller.Controller;

public class GroupDialog extends JDialog{
	
	private JPanel mainContainer, btnPanel;
	private JButton proceedBtn;
	private Controller cont;
	
	public GroupDialog(JFrame fr, Controller cont){
		super(fr);
		
		this.cont = cont;
		
		mainContainer = (JPanel) this.getContentPane();
		mainContainer.setLayout(new BorderLayout());
		
		//BUTTON CONTAINER
		btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		
		proceedBtn = new JButton("Proceed");
		btnPanel.add(proceedBtn);
		
		this.addComponents();
		
		mainContainer.add(btnPanel, BorderLayout.SOUTH);

		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack();	
	}
	
	private void addComponents(){
		
	}
}
