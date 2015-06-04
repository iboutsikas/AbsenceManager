package us.absencemanager.ui.nikos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
	private JMenuBar menuBar;
	private JMenu menuAbsences,menuStudent,menuGroupOfStudents,menuHelp;
	private JMenuItem newAbsences,editAbsences,viewAbsences,addStudent,viewStudent,editStudent,newGroupOfStudents,editGroupOfStudents,getHelp;
	private JPanel mainPanel,emptyPanel;
	private JLabel titleFrame,fEmptyPanel;
	
	private JFrame thisFrame;
	
	AddAbsences AddAbsencesClass;
	AddStudent AddStudentClass;
	ViewStudent ViewStudentClass;
	EditStudent EditStudentClass;
	ViewAbsences ViewAbsencesClass;
	EditAbsences EditAbsencesClass;
	EditGroupOfStudents EditGroupOfStudentsClass;
	NewGroupOfStudents NewGroupOfStudentsClass;
	public MainFrame(){
		super();
		thisFrame=this;
		this.setTitle("City College Practical");
		//this.setSize(400,400);
	
		mainPanel = new JPanel(new BorderLayout());
		emptyPanel=new JPanel();
		emptyPanel.setLayout(new BorderLayout());
		
		fEmptyPanel=new JLabel("");
		
		menuBar = new JMenuBar();
		menuAbsences = new JMenu("Absences");
		menuStudent=new JMenu("Student");
		menuGroupOfStudents=new JMenu("Group of students");
		menuHelp=new JMenu("Help");
		newAbsences = new JMenuItem("New absences");
		editAbsences=new JMenuItem("Edit absences");
		viewAbsences=new JMenuItem("View absences");
		addStudent=new JMenuItem("Add student");
		editStudent=new JMenuItem("Edit student");
		viewStudent=new JMenuItem("View student");
		newGroupOfStudents=new JMenuItem("New group of students");
		editGroupOfStudents=new JMenuItem("Edit group of students");
		getHelp=new JMenuItem("Get help");
		
		titleFrame = new JLabel("Object Oriented Programming 2014-2015");
		
		menuAbsences.add(newAbsences);
		menuAbsences.add(editAbsences);
		menuAbsences.add(viewAbsences);	
		
		menuStudent.add(addStudent);
		menuStudent.add(editStudent);
		menuStudent.add(viewStudent);
		
		menuGroupOfStudents.add(newGroupOfStudents);
		menuGroupOfStudents.add(editGroupOfStudents);
		
		menuHelp.add(getHelp);
		
		menuBar.add(menuAbsences);
		menuBar.add(menuStudent);
		menuBar.add(menuGroupOfStudents);
		menuBar.add(menuHelp);
		
		
		
		
		
		
		
		newAbsences.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel= new AddAbsences(thisFrame);
				add(mainPanel,BorderLayout.CENTER);
				getContentPane();
				pack();
			}
		});
		viewAbsences.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel= new ViewAbsences();
				add(mainPanel,BorderLayout.CENTER);
				getContentPane();
				pack();
			}
		});
		editAbsences.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel= new EditAbsences();
				add(mainPanel,BorderLayout.CENTER);
				mainPanel.setOpaque(true);
				getContentPane();
				pack();
			}
		});
		addStudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel= new AddStudent();
				add(mainPanel,BorderLayout.CENTER);
				getContentPane();
				pack();
			}
		});
		viewStudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel= new ViewStudent();
				add(mainPanel,BorderLayout.CENTER);
				mainPanel.setOpaque(true);
				getContentPane();
				pack();
			}
		});
		editStudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel= new EditStudent();
				add(mainPanel,BorderLayout.CENTER);
				mainPanel.setOpaque(true);
				getContentPane();
				pack();
			}
		});
		newGroupOfStudents.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel= new NewGroupOfStudents();
				add(mainPanel,BorderLayout.CENTER);
				mainPanel.setOpaque(true);
				getContentPane();
				pack();
			}
		});
		editGroupOfStudents.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel= new EditGroupOfStudents();
				add(mainPanel,BorderLayout.CENTER);
				mainPanel.setOpaque(true);
				getContentPane();
				pack();
			}
		});
		AddAbsencesClass=new AddAbsences(thisFrame);
		mainPanel.add(AddAbsencesClass,BorderLayout.CENTER);
		
		
		this.add(menuBar,BorderLayout.NORTH);
		this.add(mainPanel,BorderLayout.CENTER);
		this.add(titleFrame,BorderLayout.SOUTH);
		this.setVisible(true);
		this.pack();
	}

}
