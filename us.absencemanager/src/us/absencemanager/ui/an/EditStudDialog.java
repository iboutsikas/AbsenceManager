package us.absencemanager.ui.an;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.MenuItem;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import us.absencemanager.controller.Controller;
import us.absencemanager.exceptions.NoDataFoundException;

public class EditStudDialog extends JDialog{

	private JPanel mainContainer, centerPanel;
	private JTable studentsTable;
	private StudentTableModel model;
	private Controller cont;
	private ArrayList<Boolean> booleanList;
	private EditStudDialog thisFrame;
	private TreeMap<String,Integer> map;
	
	public EditStudDialog(JFrame fr, Controller cont){
		super(fr);
		thisFrame = this;
		this.cont= cont;
		
		mainContainer = (JPanel) this.getContentPane();
		mainContainer.setLayout(new BorderLayout());
		
				
		
		this.addComponents();
		this.addListeners();
		mainContainer.add(centerPanel, BorderLayout.CENTER);
		
		this.setTitle("Edit / View all Students");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack();
		
	}
	
	private void addComponents(){
		
		
		this.centerPanel = new JPanel();
		this.centerPanel.setLayout(new BorderLayout());
		this.createTable();
	}
	
	private void createTable(){
		this.studentsTable = new JTable();		
		
		this.model = new StudentTableModel();
		this.studentsTable.setModel(model);
		try{
			this.model.setData(cont.getStudents(), getStudentAbsences());
		} catch (NullPointerException e){
			e.printStackTrace();
		}
		
		this.centerPanel.add(new JScrollPane(studentsTable), BorderLayout.CENTER);
	}
	
	public TreeMap<String, Integer> getStudentAbsences(){
		this.map =new  TreeMap<String , Integer> ();
		for(int i = 0; i<cont.getStudents().size(); i++){
			try {
				this.map.put(cont.getStudents().get(i).getId(), cont.getStudentAbsences(cont.getStudents().get(i).getId()).values().size()) ;
			} catch (NoDataFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		return this.map;
	}
	
	
	private void addListeners(){
	}

}
