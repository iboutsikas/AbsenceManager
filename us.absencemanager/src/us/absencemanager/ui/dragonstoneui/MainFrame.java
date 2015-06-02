package us.absencemanager.ui.dragonstoneui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import us.absencemanager.controller.Controller;
import us.absencemanager.exceptions.AlreadyExistsException;
import us.absencemanager.exceptions.NoDataFoundException;


public class MainFrame extends JFrame implements AdditionListener {
	private Controller c = Controller.getInstance();
	private ControlPanel controlPanel;
	private JPanel leftPane;
	private TablePanel tablePanel;
	private MenuBar menuBar;
	private ExistingStudentPanel eStPanel;
	private int currentGroupId;
	
	public MainFrame() {
		try {
			c.loadAll();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "There was an error loading previous data", "Load Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		
		menuBar = new MenuBar();
		controlPanel = new ControlPanel(c.getStudentGroups(), c.getUnits());
		leftPane = new JPanel(new GridLayout(2, 1));
		tablePanel = new TablePanel();
		eStPanel = new ExistingStudentPanel();
		
		/**
		 * Load students from the selected group to the JTable
		 */
		controlPanel.setControlListener(new ControlListener() {
			public void loadEvent(ControlEvent ce) {
				try {
					tablePanel.initModel();
					tablePanel.setData(c.getStudentsInGroup(ce.getGroupId()));
					currentGroupId = ce.getGroupId();
				} catch (NoDataFoundException e) {
					JOptionPane.showMessageDialog(MainFrame.this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		eStPanel.populateList(c.getStudents());
		eStPanel.setAdditionListener(this);
		
		/**
		 * This method handles all additions from the new menu.
		 */
		menuBar.setAdditionListener(this);
		
		
		setJMenuBar(menuBar);
		leftPane.add(controlPanel);
		leftPane.add(eStPanel);
		add(leftPane, BorderLayout.WEST);
		add(tablePanel, BorderLayout.CENTER);
		
		setTitle("Absence Manager");
		setPreferredSize(new Dimension(1000, 600));
		setSize(new Dimension(1000, 600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void additionEventRaised(CustomEvent ev) {
		if(ev instanceof StudentEvent) { // Student Events
			StudentEvent s = (StudentEvent)ev;
			try {
				c.addStudent(s.getId(), s.getfName(), s.getlName(), s.getEmail());
				if(s.getAdd()) {
					c.addStudentToGroup(s.getId(), 1);
					tablePanel.refresh();
				}
			} catch (AlreadyExistsException e) {
				JOptionPane.showMessageDialog(MainFrame.this, "The student already exists (ID should be unique)!", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (NoDataFoundException e) {
				JOptionPane.showMessageDialog(MainFrame.this, "Could not add student to current group!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (ev instanceof GroupEvent) { // Group Events
			GroupEvent ge = (GroupEvent) ev;
			try {
				c.addStudentGroup(ge.getName());
				controlPanel.setGroupData(c.getStudentGroups());
			} catch (AlreadyExistsException e) {
				JOptionPane.showMessageDialog(MainFrame.this, "Could not add the group!\nIf you are getting this there is something really wrong with the IDs", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (ev instanceof UnitEvent) { // Unit Events 
			UnitEvent ue = (UnitEvent) ev;
			try {
				c.addUnit(ue.getId(), ue.getName(), ue.getAbs());
				controlPanel.setUnitData(c.getUnits());
			} catch (AlreadyExistsException e) {
				JOptionPane.showMessageDialog(MainFrame.this, "The unit already exists (ID should be unique)!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public void saveEventRaised() {
		try {
			c.saveAll("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void moveToGroupEvent(String id) {
		try {
			c.addStudentToGroup(id, currentGroupId);
			tablePanel.refresh();
		} catch (NoDataFoundException e) {
			e.printStackTrace();
		} catch (AlreadyExistsException e) {
			e.printStackTrace();
		}
	}
	
	public void removeFromGroupEvent() {
		String sId = tablePanel.getSelectedStudent();
		try {
			c.removeStudentFromGroup(sId, currentGroupId);
			tablePanel.refresh();
		} catch (NoDataFoundException e) {
			e.printStackTrace();
		}
	}
}