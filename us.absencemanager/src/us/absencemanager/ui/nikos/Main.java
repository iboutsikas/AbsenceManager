package us.absencemanager.ui.nikos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import us.absencemanager.controller.Controller;

public class Main extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenu menuStudents,menuGroupOfStudents,menuAbsences,menuHelp;
	private JMenuItem studentsAdd,studentsEdit,studentsRemove,studentsView,groupOfStudentsAdd,groupOfStudentsEdit,groupOfStudentsRemove,groupOfStudentsView,absencesAdd,absencesEdit,absencesLoad,absencesClose,helpGetHelp;
	private JPanel mainPanel,mainConPanel;
	private Controller controller;
	
	private JFrame thisFrame;
	
	private AddStudent addStudent;
	private AddAbsencesFS addAbsences;
	private EditAbsencesFS editAbsencesFS;
	
	public Main(){
		super();
		controller  = Controller.getInstance();
		thisFrame=this;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("CITY COLLEGE PRACTICAL");
		this.getContentPane().setLayout(new BorderLayout());
		
		mainPanel =new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainConPanel = new JPanel();
		
		menuBar = new JMenuBar();
		menuStudents = new JMenu("Students");
		menuGroupOfStudents=new JMenu("Group of students");
		menuAbsences = new JMenu("Absences");
		menuHelp=new JMenu("Help");
		
		studentsAdd=new JMenuItem("Add Student");
		studentsEdit=new JMenuItem("Edit Student");
		studentsRemove=new JMenuItem("Remove Student");
		studentsView=new JMenuItem("View Student");
		groupOfStudentsAdd=new JMenuItem("Add group of students");
		groupOfStudentsEdit=new JMenuItem("Edit group of students");
		groupOfStudentsRemove=new JMenuItem("Remove group of students");
		groupOfStudentsView=new JMenuItem("View group of students");
		absencesAdd=new JMenuItem("New Absences");
		absencesEdit=new JMenuItem("Edit Absences");
		absencesLoad = new JMenuItem("View Absences");
		absencesClose=new JMenuItem("Close Absences");
		helpGetHelp = new JMenuItem("Get Help");
		
		//Add items in MenuBar
		menuBar.add(menuAbsences);
		menuBar.add(menuStudents);
		menuBar.add(menuGroupOfStudents);
		menuBar.add(menuHelp);
			
		//Add items in menu Students
		menuStudents.add(studentsAdd);
		menuStudents.add(studentsEdit);
		menuStudents.add(studentsRemove);
		menuStudents.add(studentsView);
				
		//Add items in menu Group of students
		menuGroupOfStudents.add(groupOfStudentsAdd);
		menuGroupOfStudents.add(groupOfStudentsEdit);
		menuGroupOfStudents.add(groupOfStudentsRemove);
		menuGroupOfStudents.add(groupOfStudentsView);
			
		//Add items in menu Absences
		menuAbsences.add(absencesAdd);
		menuAbsences.add(absencesEdit);
		menuAbsences.add(absencesLoad);
		menuAbsences.add(absencesClose);
		//Add items in menu Help
		menuHelp.add(helpGetHelp);
		
		absencesAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel = new AddAbsencesFS();
				add(mainPanel,BorderLayout.CENTER);
				thisFrame.getContentPane();
				thisFrame.pack();
				System.out.print("Work");
			}
		});
		absencesEdit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel= new EditAbsencesFS();
				add(mainPanel,BorderLayout.CENTER);
				thisFrame.getContentPane();
				thisFrame.pack();
			}
		});
		absencesLoad.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel= new ViewAbsencesFS();
				add(mainPanel,BorderLayout.CENTER);
				thisFrame.getContentPane();
				thisFrame.pack();
			}
		});
		absencesClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				thisFrame.getContentPane();
				thisFrame.pack();
			}
		});
		studentsAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel= new AddStudent();
				add(mainPanel,BorderLayout.CENTER);
				thisFrame.getContentPane();
				thisFrame.pack();
				System.out.print("Work");
			}
		});
		studentsRemove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel= new DeleteStudentFS();
				add(mainPanel,BorderLayout.CENTER);
				thisFrame.getContentPane();
				thisFrame.pack();
			}
		});
		
		//Add AddAbsencesFS
		addAbsences = new AddAbsencesFS();
		mainPanel.add(addAbsences,BorderLayout.CENTER);
		this.add(mainPanel,BorderLayout.CENTER);
		this.add(menuBar,BorderLayout.NORTH);
		this.pack();
		this.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
