package us.absencemanager.ui;
import us.absencemanager.*;
import us.absencemanager.controller.Controller;
import us.absencemanager.exceptions.AlreadyExistsException;
import us.absencemanager.model.StudentGroup;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8838248803600923866L;
	
	private JMenuBar menuBar;
	private JMenu menuUnit,menuStudents,menuGroupOfStudents,menuAbsences,menuHelp;
	private JMenuItem studentsAdd,studentsEdit,studentsRemove,groupOfStudentsAdd,groupOfStudentsEdit,groupOfStudentsRemove,absencesAdd,absencesEdit,absencesRemove,absencesLoad,helpGetHelp;
	private FirstPanel fPanel;
	private JPanel btnContainer, previousPanel=null, backBtnContainer;
	private JButton okBtn, backBtn;
	private JLabel footerLb;
	private Controller controller;
	private AddStudPanel addPnl;
	private JFrame thisFrame;
	
	
	public MainFrame(){
		super();
		
		thisFrame = this;
		controller = Controller.getInstance();
		Container mainContainer = getContentPane();
		mainContainer.setLayout(new BorderLayout());
		createMenu();
		mainContainer.add(menuBar, BorderLayout.NORTH);
		
		fPanel = new FirstPanel();
		mainContainer.add(fPanel, BorderLayout.CENTER);	
		
		this.createBtnContainer();
		this.add(btnContainer, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("City College Absense System");
		this.getContentPane();
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		
		this.loadGroups();
	}
	
	
	public void createMenu(){
		//Create the objects
		menuBar = new JMenuBar();
		menuUnit = new JMenu("Units");
		menuStudents = new JMenu("Students");
		menuGroupOfStudents=new JMenu("Group of students");
		menuAbsences = new JMenu("Absences");
		menuHelp=new JMenu("Help");
		
		studentsAdd=new JMenuItem("Add Student");
		studentsAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addPnl = new AddStudPanel(thisFrame);
				
			}
			
		});
		
		studentsEdit=new JMenuItem("Edit Student");
		studentsRemove=new JMenuItem("Remove Student");
		groupOfStudentsAdd=new JMenuItem("Add group of students");
		groupOfStudentsEdit=new JMenuItem("Edit group of students");
		groupOfStudentsRemove=new JMenuItem("Remove group of students");
		absencesAdd=new JMenuItem("Add Absences");
		absencesEdit=new JMenuItem("Edit Absences");
		absencesRemove=new JMenuItem("Remove Absences");
		absencesLoad = new JMenuItem("Load Absences");
		helpGetHelp = new JMenuItem("Get Help");
		
		//Add items in MenuBar
		menuBar.add(menuUnit);
		menuBar.add(menuStudents);
		menuBar.add(menuGroupOfStudents);
		menuBar.add(menuAbsences);
		menuBar.add(menuHelp);
		
		//Add items in menu Students
		menuStudents.add(studentsAdd);
		menuStudents.add(studentsEdit);
		menuStudents.add(studentsRemove);
		
		//Add items in menu Group of students
		menuGroupOfStudents.add(groupOfStudentsAdd);
		menuGroupOfStudents.add(groupOfStudentsEdit);
		menuGroupOfStudents.add(groupOfStudentsRemove);
		
		//Add items in menu Absences
		menuAbsences.add(absencesAdd);
		menuAbsences.add(absencesEdit);
		menuAbsences.add(absencesRemove);
		menuAbsences.add(absencesLoad);
		//Add items in menu Help
		menuHelp.add(helpGetHelp);
	}
	
	public void createBtnContainer(){
		btnContainer = new JPanel();
		btnContainer.setLayout(new BorderLayout());
		this.createButton();
		btnContainer.add(okBtn, BorderLayout.EAST);
		this.createBackBtnContainer();
		btnContainer.add(backBtnContainer, BorderLayout.CENTER);
	}
	
	public void createButton(){
		okBtn = new JButton("Submit");
		okBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
	}
	
	public void createBackBtnContainer(){
		backBtnContainer = new JPanel();
		backBtnContainer.setLayout(new BorderLayout());
		backBtnContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 2));
		this.createBackButton();
		backBtnContainer.add(backBtn, BorderLayout.EAST);
		footerLb = new JLabel("Student Absenses OOP - 2015");
		footerLb.setFont(new Font("Courier New", Font.ITALIC, 11));
		footerLb.setForeground(Color.GRAY);
		footerLb.setVerticalAlignment(JLabel.BOTTOM);
		footerLb.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
		backBtnContainer.add(footerLb, BorderLayout.CENTER);
		
	}
	
	public void createBackButton(){
		backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}

	public void loadGroups(){
		
		//Test
		try {
			controller.addStudentGroup("jdaij");
			controller.addStudentGroup("okokoko");
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int listSize = 0;
		listSize = controller.getStudentGroups().size();
		
		for(int i = 0; i < listSize; i++){
			fPanel.populateList(controller.getStudentGroups().get(i).getName());
		}
	}
}

