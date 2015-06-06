package us.absencemanager.ui.an;

import java.awt.BorderLayout;
import java.util.TreeMap;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import us.absencemanager.controller.Controller;
import us.absencemanager.exceptions.NoDataFoundException;

/**
 * @authors Athanasios Doulgeris , Nikolaos Doumpalas
 *
 */
public class EditStudDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4829686926989019442L;
	private JPanel mainContainer, centerPanel;
	private JTable studentsTable;
	private StudentTableModel model;
	private Controller cont;
	private TreeMap<String,Integer> map;

	
	/**
	 * @param fr
	 * @param cont
	 */
	public EditStudDialog(JFrame fr, Controller cont){
		super(fr);

		this.cont= cont;
		
		mainContainer = (JPanel) this.getContentPane();
		mainContainer.setLayout(new BorderLayout());
		
				
		
		this.addComponents();
		mainContainer.add(centerPanel, BorderLayout.CENTER);
		
		this.setTitle("Edit / View all Students");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack();
		
	}
	
	/**
	 * 
	 */
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
	
	/**
	 * @return
	 */
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

	
	

}
