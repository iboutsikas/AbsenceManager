package us.absencemanager.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import us.absencemanager.exceptions.AlreadyExistsException;
import us.absencemanager.exceptions.NoDataFoundException;
import us.absencemanager.model.Absence;
import us.absencemanager.model.DataLayer;
import us.absencemanager.model.Student;
import us.absencemanager.model.StudentGroup;
import us.absencemanager.model.Unit;

/**
 * The Manager class is a singleton. It handles interaction between the Model objects and the View.
 * @author Ioannis Boutsikas
 */
public class Controller {
	private static Controller instance = new Controller();
	private static DataLayer dl = DataLayer.getInstance();
	
	
	private Controller() {
		//JUST TO DEFY INSTANTIATION
	}
	/**
	 * 
	 * @return The single instance of Manager.
	 */
	public static Controller getInstance() {
		return instance;
	}
	
	public ArrayList<Student> getStudents() {
		ArrayList<Student> temp = new ArrayList<Student>(dl.getStudents());		
		return (ArrayList<Student>) Collections.unmodifiableList(temp);
	}
	
	public ArrayList<StudentGroup> getStudentGroups() {
		ArrayList<StudentGroup> temp = new ArrayList<StudentGroup>(dl.getStudentGroups());		
		return (ArrayList<StudentGroup>) Collections.unmodifiableList(temp);
	}
	
	public ArrayList<Unit> getUnits() {
		ArrayList<Unit> temp = new ArrayList<Unit>(dl.getUnits());		
		return (ArrayList<Unit>) Collections.unmodifiableList(temp);
	}
	
	public void addStudent(String id, String firstName, String lastName, String email) throws AlreadyExistsException {
		Student s = new Student(id,firstName,lastName,email);
		dl.addStudent(s);
	}
	
	public void addStudentGroup(String name) throws AlreadyExistsException {
		StudentGroup sg = new StudentGroup(name);
		dl.addStudentGroup(sg);
	}
	
	public void addUnit(String id, String name, int maxAbsences) throws AlreadyExistsException {
		dl.addUnit(new Unit(id, name, maxAbsences));
	}
	
	public void addStudentToGroup(String studentId, int groupId) throws NoDataFoundException, AlreadyExistsException {
		try {
			Student s = dl.findStudentById(studentId);
			StudentGroup sg = dl.findGroupById(groupId);
			
			sg.addStudent(s);
		} catch (NoDataFoundException e) {
			throw e;
		} catch (AlreadyExistsException e) {
			throw e;
		}		
	}
	
	public void addAbsenceToStudent(String studentId, String unitId, String classroom, String date) throws NoDataFoundException {
		dl.addAbsenceToStudent(studentId, new Absence(unitId, classroom, date));
	}
	
	public void saveAll(String filePath) throws IOException {
		dl.saveStudents(new File(filePath+"students.dat"));
		dl.saveStudentGroups(new File(filePath+"studentGroup.dat"));
		dl.saveUnits(new File(filePath+"units.dat"));
	}
}