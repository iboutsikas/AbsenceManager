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

import javax.swing.JApplet;
import javax.swing.JButton;
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

	private JPanel mainContainer, centerPanel, btnPanel;
	private JButton viewBtn, deleteBtn;
	private JTable studentsTable;
	private StudentTableModel model;
	private Controller cont;
	private ArrayList<Boolean> booleanList;
	private JPopupMenu popUp;
	private EditStudDialog thisFrame;
	
	public EditStudDialog(JFrame fr, Controller cont){
		super(fr);
		thisFrame = this;
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
		this.viewBtn = new JButton("View Absence information");
		this.btnPanel.add(viewBtn);
		
		this.deleteBtn = new JButton("Delete Student(s)");
		this.btnPanel.add(deleteBtn);
		
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
		
		this.centerPanel.add(new JScrollPane(studentsTable), BorderLayout.CENTER);
	}
	
	private void addListeners(){
			viewBtn.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					int size=-1;
					size = model.getRowCount();
					booleanList = new ArrayList<Boolean>();
					
					for(int i = 0; i<size; i++){
						booleanList.add((Boolean) model.getValueAt(i, 3));
						if(booleanList.get(i) == true){
							
								//cont.getStudents().get(i).								
							
			
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
