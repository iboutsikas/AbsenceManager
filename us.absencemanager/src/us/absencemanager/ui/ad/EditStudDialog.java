package us.absencemanager.ui.ad;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import us.absencemanager.controller.Controller;
import us.absencemanager.exceptions.NoDataFoundException;

public class EditStudDialog extends JDialog{

	private JPanel mainContainer, centerPanel, btnPanel;
	private JButton createBtn;
	private JTable studentsTable;
	private StudentTableModel model;
	private Controller cont;
	
	public EditStudDialog(JFrame fr, Controller cont){
		super(fr);
		
		this.cont= cont;
		
		mainContainer = (JPanel) this.getContentPane();
		mainContainer.setLayout(new BorderLayout());
		
		//BUTTON CONTAINER
		btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
				
		
		this.addComponents();
		this.addListeners();
		mainContainer.add(btnPanel, BorderLayout.SOUTH);
		mainContainer.add(centerPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack();
		
	}
	
	private void addComponents(){
		this.createBtn = new JButton("Finish");
		this.btnPanel.add(createBtn);
		
		this.centerPanel = new JPanel();
		this.centerPanel.setLayout(new BorderLayout());
		this.createTable();
	}
	
	private void createTable(){
		this.studentsTable = new JTable();		
		
		this.model = new StudentTableModel();
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

	}
}
