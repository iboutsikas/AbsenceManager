package us.absencemanager.ui.ad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.text.DateFormatter;

import us.absencemanager.controller.Controller;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3942537849319227546L;
	private Controller controller;
	private AddUnitDialog addUnitDlg;
	private AddGroupDialog addGroupDlg;
	private AddStudDialog addStudDlg;
	private AbsenceDialog addAbsDlg;
	private EditStudDialog editStudDlg;
	private JLabel footerLb, groupLabel, unitLabel, classLabel, dateLb, timeLb;
	private JComboBox dropDownGroup, dropDownUnit;
	private JTextField classTxt;
	private Calendar calendar;
	private SpinnerDateModel model, modelD;
	private JSpinner datePicker, timePicker;
	private JButton proceedBtn;
	private JMenuBar menuBar;
	private JMenu menuUnit,menuStudents,menuGroupOfStudents,menuAbsences,menuHelp;
	private JMenuItem unitAdd,studentsAdd,studentsEdit,studentsRemove,groupOfStudentsAdd,groupOfStudentsEdit,groupOfStudentsRemove,absencesAdd,absencesEdit,absencesRemove,absencesLoad,helpGetHelp;
	private JPanel mainContainer, btnContainer, footerContainer, centerContainer, centerPanel;
	private GridBagConstraints cons;
	private GridBagLayout gridBag;
	private DefaultComboBoxModel modelU, modelG;
	
	
	public MainWindow(){
		super();
		
		this.controller = Controller.getInstance();
		//Load on open
		try {
			this.controller.loadAll();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "No saved files found", "Startup load", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		this.mainContainer = (JPanel) this.getContentPane();
		this.mainContainer.setLayout(new BorderLayout());
		
		this.addComponents();
		this.addListeners((JFrame)this);
		
		
		this.setTitle("City College Absense System");
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void addComponents(){
		
		this.centerContainer = new JPanel();
		this.mainContainer.add(centerContainer, BorderLayout.CENTER);	
		
		this.btnContainer = new JPanel();
		this.btnContainer.setLayout(new BorderLayout());
		
		this.proceedBtn = new JButton("Submit");
		this.btnContainer.add(proceedBtn, BorderLayout.EAST);
		
		
		
		this.footerContainer = new JPanel();
		this.footerContainer.setLayout(new BorderLayout());
		this.footerContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 2));
		this.btnContainer.add(footerContainer, BorderLayout.CENTER);
		this.mainContainer.add(btnContainer, BorderLayout.SOUTH);
		
		this.footerLb = new JLabel("Student Absenses OOP - 2015");
		this.footerLb.setFont(new Font("Courier New", Font.ITALIC, 11));
		this.footerLb.setForeground(Color.GRAY);
		this.footerLb.setVerticalAlignment(JLabel.BOTTOM);
		this.footerLb.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
		this.footerContainer.add(footerLb, BorderLayout.CENTER);
		
		addMenu();
		createCenterContainer();
	}
	
	private void createCenterContainer(){
		this.centerContainer = new JPanel();
		
		this.centerContainer.setBorder(BorderFactory.createEmptyBorder(10, 1, 1, 1));
		this.centerContainer.setLayout(new BorderLayout());
		
		cons = new GridBagConstraints();
		gridBag = new GridBagLayout();
		
		this.centerPanel = new JPanel();
		this.centerPanel.setLayout(gridBag);
		
		cons.insets = new Insets(1,1,1,1);
		
		this.groupLabel = new JLabel("Choose Group Of Students:");
		cons.gridx = 0;
		cons.gridy = 0;
		gridBag.setConstraints(groupLabel, cons);
		centerPanel.add(groupLabel);
		
		this.dropDownGroup = new JComboBox<String>();
		cons.gridx = 1;
		cons.gridy = 0;
		gridBag.setConstraints(dropDownGroup, cons);
		centerPanel.add(dropDownGroup);
		
		this.unitLabel = new JLabel("Choose Unit:");
		cons.gridx = 0;
		cons.gridy = 1;
		gridBag.setConstraints(unitLabel, cons);
		centerPanel.add(unitLabel);
		
		this.dropDownUnit = new JComboBox<String>();
		cons.gridx = 1;
		cons.gridy = 1;
		
		gridBag.setConstraints(dropDownUnit, cons);
		centerPanel.add(dropDownUnit);
		
		this.loadDropDownLists();
		dropDownUnit.setPreferredSize(dropDownGroup.getPreferredSize());
		
		this.classLabel = new JLabel("Classroom:");
		cons.gridx = 0;
		cons.gridy = 2;
		gridBag.setConstraints(classLabel, cons);
		centerPanel.add(classLabel);
		
		this.classTxt = new JTextField("");
		cons.gridx = 1;
		cons.gridy = 2;
		classTxt.setPreferredSize(dropDownGroup.getPreferredSize());
		gridBag.setConstraints(classTxt, cons);
		centerPanel.add(classTxt);
		
		this.timeLb = new JLabel("Time:");
		cons.gridx = 0;
		cons.gridy = 3;
		gridBag.setConstraints(timeLb, cons);
		centerPanel.add(timeLb);
		
		this.dateLb = new JLabel("Date:");
		cons.gridx = 0;
		cons.gridy = 4;
		gridBag.setConstraints(dateLb, cons);
		centerPanel.add(dateLb);
		
		createCalendar();
		
		

		

		this.centerContainer.add(centerPanel, BorderLayout.CENTER);
		this.mainContainer.add(centerContainer, BorderLayout.CENTER);
	}
	
	private void addMenu(){
		//Create the objects
		this.menuBar = new JMenuBar();
		this.menuUnit = new JMenu("Units");
		this.menuStudents = new JMenu("Students");
		this.menuGroupOfStudents=new JMenu("Group of students");
		this.menuAbsences = new JMenu("Absences");
		this.menuHelp=new JMenu("Help");

		this.studentsAdd=new JMenuItem("Add Student");


		this.studentsEdit=new JMenuItem("View All Students");
		this.studentsRemove=new JMenuItem("Remove Students");
		this.groupOfStudentsAdd=new JMenuItem("Add group of students");
		this.groupOfStudentsEdit=new JMenuItem("View groups of students");
		this.groupOfStudentsRemove=new JMenuItem("Remove group of students");
		this.absencesAdd=new JMenuItem("Add Absences");


		this.absencesEdit=new JMenuItem("View Absences");
		this.helpGetHelp = new JMenuItem("Get Help");
		this.unitAdd = new JMenuItem("Add Unit");

		//Add items in MenuBar
		this.menuBar.add(menuUnit);
		this.menuBar.add(menuStudents);
		this.menuBar.add(menuGroupOfStudents);
		this.menuBar.add(menuAbsences);
		this.menuBar.add(menuHelp);


		this.menuUnit.add(unitAdd);
		//Add items in menu Students
		this.menuStudents.add(studentsAdd);
		this.menuStudents.add(studentsEdit);
		this.menuStudents.add(studentsRemove);

		//Add items in menu Group of students
		this.menuGroupOfStudents.add(groupOfStudentsAdd);
		this.menuGroupOfStudents.add(groupOfStudentsEdit);
		this.menuGroupOfStudents.add(groupOfStudentsRemove);

		//Add items in menu Absences
		this.menuAbsences.add(absencesAdd);
		this.menuAbsences.add(absencesEdit);
		//Add items in menu Help
		this.menuHelp.add(helpGetHelp);

		this.mainContainer.add(menuBar, BorderLayout.NORTH);
	}
	
	private void createCalendar(){
		calendar = Calendar.getInstance();
		
		model = new SpinnerDateModel();
		
		modelD = new SpinnerDateModel();
        
		model.setValue(calendar.getTime());
		
		modelD.setValue(calendar.getTime());
		
        timePicker = new JSpinner(model);
        
        Calendar cal = Calendar.getInstance();
        
		JSpinner.DateEditor editor = new JSpinner.DateEditor(timePicker,"HH:mm");
	    DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
	    formatter.setAllowsInvalid(false); // this makes what you want
	    formatter.setOverwriteMode(true);
	     
	    timePicker.setEditor(editor);
        
	    System.out.println(new SimpleDateFormat("HH:mm").format(timePicker.getValue()));
		cons.gridx = 1;
		cons.gridy = 3;
		timePicker.setPreferredSize(dropDownGroup.getPreferredSize());
		gridBag.setConstraints(timePicker, cons);
		centerPanel.add(timePicker);
		
        
        
        datePicker = new JSpinner(modelD);

        JSpinner.DateEditor editorD = new JSpinner.DateEditor(datePicker,"dd/MM/yy");
		DateFormatter formatterD = (DateFormatter)editorD.getTextField().getFormatter();
	    formatterD.setAllowsInvalid(false); // this makes what you want
	    formatterD.setOverwriteMode(true);
	     
	    datePicker.setEditor(editorD);
        
	    System.out.println(new SimpleDateFormat("dd/MM/yy").format(datePicker.getValue()));
		cons.gridx = 1;
		cons.gridy = 4;
		datePicker.setPreferredSize(dropDownGroup.getPreferredSize());
		gridBag.setConstraints(datePicker, cons);
		centerPanel.add(datePicker);
		
	}
	
	private void addListeners(JFrame thisFrame){
		
		studentsAdd.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addStudDlg = new AddStudDialog(thisFrame, controller);
			}
			
		});
		
		absencesAdd.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String unit = null, date = null;
				int groupId= -1;
				for(int i = 0; i<controller.getStudentGroups().size(); i++){
					if(controller.getStudentGroups().get(i).getName() == ((MainWindow) thisFrame).getSelectedGroup()){
						groupId = controller.getStudentGroups().get(i).getID();
					}
				}
				if(groupId == -1){
					JOptionPane.showMessageDialog(null, "Select or create a group of students.", "Error in reading group", JOptionPane.ERROR_MESSAGE);
				}
				else{
					String dateTime = new SimpleDateFormat("HH:mm").format(timePicker.getValue()) + " " +new SimpleDateFormat("dd/MM/yy").format(datePicker.getValue());
					System.out.println(dateTime);
					addAbsDlg = new AbsenceDialog(thisFrame, controller, groupId, unit, dateTime,"afd");					
				}

			}
			
		});
		
		proceedBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String unit = null, classroom = classTxt.getText();
				String dateTime = new SimpleDateFormat("HH:mm").format(timePicker.getValue()) + " " +new SimpleDateFormat("dd/MM/yy").format(datePicker.getValue());
				int groupId= -1;
				for(int i = 0; i<controller.getStudentGroups().size(); i++){
					if(controller.getStudentGroups().get(i).getName() == ((MainWindow) thisFrame).getSelectedGroup()){
						groupId = controller.getStudentGroups().get(i).getID();
					}
				}
				for(int i = 0; i<controller.getUnits().size(); i++){
					if(controller.getUnits().get(i).getName() == ((MainWindow) thisFrame).getSelectedUnit()){
						unit = controller.getUnits().get(i).getId();
					}
				}
				
				if(groupId == -1){
					JOptionPane.showMessageDialog(null, "Select or create a group of students.", "Error in reading group", JOptionPane.ERROR_MESSAGE);
				}
				else if(unit == null){
					JOptionPane.showMessageDialog(null, "Select or create a unit.", "Error in reading unit", JOptionPane.ERROR_MESSAGE);
				}
				else if(classroom == null || classroom == ""){
					JOptionPane.showMessageDialog(null, "Select a classroom.", "Error in reading classroom", JOptionPane.ERROR_MESSAGE);
				}
				else{
					System.out.println(dateTime);
					addAbsDlg = new AbsenceDialog(thisFrame, controller, groupId, unit, dateTime,classroom);					
				}

			}
			
		});
		
		unitAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				addUnitDlg = new AddUnitDialog(thisFrame, controller);

				
				addUnitDlg.addWindowListener(new WindowAdapter(){
		            @Override
		            public void windowClosing(WindowEvent e)
		            {
		            	modelU.removeAllElements();
		            	modelG.removeAllElements();
		            	loadDropDownLists();
		            }
				});
			}
			
		});
		
		groupOfStudentsAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addGroupDlg = new AddGroupDialog(thisFrame, controller);
				
			}
			
		});
		

		
		studentsEdit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				editStudDlg = new EditStudDialog(thisFrame, controller);
				
			}
			
		});
		
		this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                int answer = JOptionPane.showConfirmDialog(thisFrame, "All your progress will be lost. Do you want to save?", "Closing", JOptionPane.YES_NO_OPTION);
                if(answer == JOptionPane.YES_OPTION){
                	try {
						controller.saveAll("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "An error occured while saving", "Saving error", JOptionPane.ERROR_MESSAGE);
					}
                }
                else{
                	e.getWindow().dispose();
                }
                
            }
		});

		
	}
	
	public void loadDropDownLists(){
		
		modelG = new DefaultComboBoxModel();
		modelU = new DefaultComboBoxModel();
		
		modelG.addElement("Add new group..");
		modelU.addElement("Add new unit...");
		 
		int listSize = 0;
		listSize = controller.getStudentGroups().size();
		
		for(int i = 0; i < listSize; i++){
		    modelG.addElement(controller.getStudentGroups().get(i).getName());
			
		}
		
		listSize = controller.getUnits().size();
		
		for(int i = 0; i < listSize; i++){
			modelU.addElement(controller.getUnits().get(i).getName());
		}
		dropDownGroup.setModel(modelG);
		dropDownUnit.setModel(modelU);
		
	}
	
	private String getSelectedGroup(){
		return dropDownGroup.getSelectedItem().toString();
	}
	
	private String getSelectedUnit(){
		return dropDownUnit.getSelectedItem().toString();
	}


}
