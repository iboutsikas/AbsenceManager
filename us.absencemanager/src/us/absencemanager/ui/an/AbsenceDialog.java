package us.absencemanager.ui.an;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import us.absencemanager.controller.Controller;
import us.absencemanager.exceptions.NoDataFoundException;
import us.absencemanager.model.Student;

/**
 * @authors Athanasios Doulgeris , Nikolaos Doumpalas
 *
 */

public class AbsenceDialog extends JDialog {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1059403725400246930L;
	private JPanel mainContainer, tableContainer, buttonContainer;
	private JButton finishBtn;
	private JTable absenceTable;
	private Controller cont;
	private AbsenceTableModel tableModel;
	private ArrayList<Boolean> booleanList;
	private String unitId, date, classroom;
	private AbsenceDialog thisFrame;
	
	/**
	 * @param fr
	 * @param cont
	 * @param groupId
	 * @param unitId
	 * @param date
	 * @param classroom
	 */
	public AbsenceDialog(JFrame fr, Controller cont,int groupId, String unitId, String date, String classroom){
		super(fr, ModalityType.APPLICATION_MODAL);
		thisFrame = this;
		this.cont = cont;
		this.unitId = unitId;
		this.date = date;
		this.classroom = classroom;
		
		mainContainer = (JPanel) this.getContentPane();
		mainContainer.setLayout(new BorderLayout());
		
		this.createBtn();
		this.createTable(groupId);
		this.addListeners();
		
		this.setTitle("Absences");
		this.pack();
		this.setLocationRelativeTo(fr);
		this.setVisible(true);
	}
	
	/**
	 * @param groupId
	 */
	private void createTable(int groupId){
		tableModel = new AbsenceTableModel();
		absenceTable = new JTable(tableModel);
		try {
			this.setData(cont.getStudentsInGroup(groupId));
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableContainer = new JPanel();
		tableContainer.setLayout(new BorderLayout());
		tableContainer.add(new JScrollPane(absenceTable), BorderLayout.CENTER);
		this.mainContainer.add(tableContainer, BorderLayout.CENTER);
		
	}
	
	/**
	 * @param students
	 */
	public void setData(List<Student> students){
		tableModel.setData(students);
	}
	
	/**
	 * 
	 */
	private void createBtn(){
		finishBtn = new JButton("Finish");
		
		buttonContainer = new JPanel();
		buttonContainer.add(finishBtn);
		this.mainContainer.add(buttonContainer, BorderLayout.SOUTH);
	}
	
	/**
	 * 
	 */
	private void addListeners(){
		finishBtn.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				int size=-1;
				size = tableModel.getRowCount();
				booleanList = new ArrayList<Boolean>();
				
				for(int i = 0; i<size; i++){
					booleanList.add((Boolean) tableModel.getValueAt(i, 3));
					if(booleanList.get(i) == false){
						try {
							cont.addAbsenceToStudent((String)tableModel.getValueAt(i, 0), unitId, classroom, date);
							//cont.getStudents().get(i).displayAbsences();
							
						} catch (NoDataFoundException e1) {
							e1.printStackTrace();
						}
					}
				}
				
				int answer = JOptionPane.showConfirmDialog(thisFrame, "Are you sure?", "Closing", JOptionPane.YES_NO_OPTION);
                if(answer == JOptionPane.YES_OPTION){
                	
					thisFrame.dispose();
					
                }
				
			}
			
		});
	}
	
}
