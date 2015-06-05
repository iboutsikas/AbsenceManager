package us.absencemanager.ui.an;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import us.absencemanager.controller.Controller;

public class GroupDialog extends JDialog{
	
	private JPanel mainContainer, btnPanel;
	private JButton proceedBtn;
	private Controller cont;
	private String groupName;
	private JTable groupTable;
	private StudentTableModel model;
	
	public GroupDialog(JFrame fr, Controller cont, String groupName){
		super(fr);
		
		this.cont = cont;
		this.groupName = groupName;
		mainContainer = (JPanel) this.getContentPane();
		mainContainer.setLayout(new BorderLayout());
		
		//BUTTON CONTAINER
		btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		
		proceedBtn = new JButton("RemoveStudents");
		btnPanel.add(proceedBtn);
		
		this.addComponents();
		
		mainContainer.add(btnPanel, BorderLayout.SOUTH);

		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack();	
	}
	
	private void addComponents(){
		model = new StudentTableModel();
		groupTable = new JTable();
		groupTable.setModel(model);
		int groupId = -1;
		
		
	}
}
