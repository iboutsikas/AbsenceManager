package us.absencemanager.ui.an;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;

import us.absencemanager.controller.Controller;
import us.absencemanager.exceptions.AlreadyExistsException;

public class AddGroupDialog extends JDialog{
	
	private JPanel mainContainer, btnPanel, centerPanel, gridPanel;
	private JButton createButton;
	private JLabel titleLb;
	private JTable studentsTable;
	private JTextField titleTxt;
	private GridBagConstraints cons;
	private GridBagLayout gridBag;
	private Controller cont;
	private AbsenceTableModel model;
	
	public AddGroupDialog(JFrame fr, Controller cont){
		super(fr);
		
		this.cont = cont;
		this.mainContainer = (JPanel) this.getContentPane();
		this.mainContainer.setLayout(new BorderLayout());
		
		this.addComponents();
		this.addListeners();
		
		
		this.pack();
		this.setModal(true);
		this.setVisible(true);
		this.setLocationRelativeTo(fr);
		
		
	}
	
	private void addComponents(){
		//BUTTON CONTAINER
		this.btnPanel = new JPanel();
		this.btnPanel.setLayout(new FlowLayout());
		
		this.createButton = new JButton("Create");
		this.btnPanel.add(createButton);
		
		this.centerPanel = new JPanel();
		this.centerPanel.setLayout(new BorderLayout());
		
		this.cons = new GridBagConstraints();
		this.gridBag = new GridBagLayout(); 
		
    	//TEXTFIELDS AND LABELS
		this.gridPanel = new JPanel();
		this.gridPanel.setLayout(gridBag);
		
		this.titleLb = new JLabel("Group title:");
		this.cons.gridx = 0;
		this.cons.gridy = 0;
		this.gridBag.setConstraints(titleLb, cons);
		this.gridPanel.add(titleLb);
		
		this.titleTxt = new JTextField("", 10);
		this.cons.gridx = 1;
		this.cons.gridy = 0;
		this.gridBag.setConstraints(titleTxt, cons);
		this.gridPanel.add(titleTxt);	
		
		this.createTable();
		
		this.centerPanel.add(gridPanel, BorderLayout.NORTH);
		this.mainContainer.add(centerPanel, BorderLayout.CENTER);
		this.mainContainer.add(btnPanel, BorderLayout.SOUTH);
	}
		
	private void createTable(){
		this.studentsTable = new JTable();		
		
		this.model = new AbsenceTableModel();
		this.studentsTable.setModel(model);
		try{
			this.model.setData(cont.getStudents());
		} catch (NullPointerException e){
			e.printStackTrace();
		}
		this.model.fireTableDataChanged();
		
		this.centerPanel.add(new JScrollPane(studentsTable), BorderLayout.CENTER);
	}
	
	private void addListeners(){
		createButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					cont.addStudentGroup(titleTxt.getText());
					JOptionPane.showMessageDialog(null, "Group Created Succesfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (AlreadyExistsException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Unable to create group. Group already exists", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});

	}

}
