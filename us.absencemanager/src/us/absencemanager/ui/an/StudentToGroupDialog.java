package us.absencemanager.ui.an;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import us.absencemanager.controller.Controller;
import us.absencemanager.exceptions.AlreadyExistsException;
import us.absencemanager.exceptions.NoDataFoundException;
import us.absencemanager.model.Student;


/**
 * @authors Athanasios Doulgeris , Nikolaos Doumpalas
 *
 */
public class StudentToGroupDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1751536192535326068L;
	private JPanel mainContainer, centerPanel,btnPanel;
	private JTable studentsTable;
	private GroupTableModel model;
	private Controller cont;
	private JButton proceedBtn;
	private int groupId;
	
	public StudentToGroupDialog(JFrame fr, Controller cont,int groupId){
		super(fr);
		this.cont= cont;
		
		this.groupId = groupId;
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
		
		this.proceedBtn = new JButton("Proceed");
		this.btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.add(proceedBtn);
		
		this.mainContainer.add(btnPanel, BorderLayout.SOUTH);
		this.createTable();
	}
	
	private void createTable(){
		ArrayList<Student> temp =new ArrayList<Student>(cont.getStudents());
		
		try {
			temp.removeAll(cont.getStudentsInGroup(groupId));
		} catch (NoDataFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.studentsTable = new JTable();		
		
		this.model = new GroupTableModel();
		
		
		
		
		this.studentsTable.setModel(model);
		try{
			this.model.setData(temp);
		} catch (NullPointerException e){
			e.printStackTrace();
		}
		
		this.centerPanel.add(new JScrollPane(studentsTable), BorderLayout.CENTER);
	}
		
	
	private void addListeners(){
		proceedBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i < model.getRowCount(); i++){
					if((Boolean)model.getValueAt(i, 3) == true){
						try{
							cont.addStudentToGroup((String)model.getValueAt(i,0), groupId); 
							
						} catch (NoDataFoundException ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Not number", "Error", JOptionPane.ERROR_MESSAGE);

						} catch (AlreadyExistsException ex){
							JOptionPane.showMessageDialog(null, "Student already in group", "Error", JOptionPane.ERROR_MESSAGE);
						}

					}
				}
				
			}
			
		});
	}
	
	

}
