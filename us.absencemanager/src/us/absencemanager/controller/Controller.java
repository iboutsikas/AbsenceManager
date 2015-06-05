package us.absencemanager.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
	
	public List<Student> getStudents() {
		ArrayList<Student> temp = new ArrayList<Student>(dl.getStudents());		
		return Collections.unmodifiableList(temp);
	}
	
	public void updateStudent(String id, String firstName, String lastName, String email) throws NoDataFoundException {
		dl.updateStudent(new Student(id,firstName, lastName, email));
	}
	public List<StudentGroup> getStudentGroups() {
		ArrayList<StudentGroup> temp = new ArrayList<StudentGroup>(dl.getStudentGroups());		
		return Collections.unmodifiableList(temp);
	}
	
	public List<Unit> getUnits() {
		ArrayList<Unit> temp = new ArrayList<Unit>(dl.getUnits());	
		return Collections.unmodifiableList(temp);
	}
	
	public void addStudent(String id, String firstName, String lastName, String email) throws AlreadyExistsException {
		Student s = new Student(id,firstName,lastName,email);
		dl.addStudent(s);
	}
	public Map<String, ArrayList<Absence>> getStudentAbsences(String studentID) throws NoDataFoundException {
		Student s = dl.findStudentById(studentID);
		return Collections.unmodifiableMap(s.getAbsences());
	}
	
	public void addStudentGroup(String name) throws AlreadyExistsException {
		StudentGroup sg = new StudentGroup(name);
		dl.addStudentGroup(sg);
	}
	
	public void addUnit(String id, String name, int maxAbsences) throws AlreadyExistsException {
		dl.addUnit(new Unit(id, name, maxAbsences));
	}
	
	public void addStudentToGroup(String studentId, int groupId) throws NoDataFoundException, AlreadyExistsException {
			Student s = dl.findStudentById(studentId);
			StudentGroup sg = dl.findGroupById(groupId);			
			sg.addStudent(s);
	}
	
	public void removeStudentFromGroup(String studentId, int groupId) throws NoDataFoundException {
		StudentGroup sg = dl.findGroupById(groupId);
		sg.removeStudent(studentId);
	}
	
	public void addAbsenceToStudent(String studentId, String unitId, String classroom, String date) throws NoDataFoundException {
		dl.addAbsenceToStudent(studentId, new Absence(unitId, classroom, date));
	}
	public void removeAbsenceFromStudent(String studentId, String unitId, String classroom, String date) throws NoDataFoundException {
		Student s =dl.findStudentById(studentId);
		s.removeAbsence(new Absence(unitId, classroom, date));
	}
	
	public List<Student> getStudentsInGroup(int groupId) throws NoDataFoundException {
		StudentGroup sg = dl.findGroupById(groupId);
		ArrayList<Student> temp = sg.getStudents();	
		return Collections.unmodifiableList(temp);
	}
	public void saveGroups(String filePath) throws IOException {
		dl.saveStudentGroups(new File(filePath+"studentGroups.dat"));
	}
	
	public void saveStudents(String filePath) throws IOException {
		dl.saveStudents(new File(filePath+"students.dat"));
	}
	
	public void saveUnit(String filePath) throws IOException {
		dl.saveUnits(new File(filePath+"units.dat"));
	}
	
	public void saveAll(String filePath) throws IOException {
		dl.saveStudents(new File(filePath+"students.dat"));
		dl.saveStudentGroups(new File(filePath+"studentGroups.dat"));
		dl.saveUnits(new File(filePath+"units.dat"));
	}
	
	public void loadAll() throws IOException, ClassNotFoundException {
		dl.loadStudents(new File("students.dat"));
		dl.loadStudentGroups(new File("studentGroups.dat"));
		dl.loadUnits(new File("units.dat"));
	}
	
	public void loadGroups() throws ClassNotFoundException, IOException {
		dl.loadStudentGroups(new File("studentGroups.dat"));
	}
	
	public void loadStudents() throws ClassNotFoundException, IOException {
		dl.loadStudents(new File("students.dat"));
	}
	
	public void loadUnits() throws ClassNotFoundException, IOException {
		dl.loadUnits(new File("units.dat"));
	}
}