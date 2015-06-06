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
 * The Controller class is a singleton. It handles interaction between the Model objects and the View.
 * @author Ioannis Boutsikas
 */
public class Controller {
	private static Controller instance = new Controller();
	private static DataLayer dl = DataLayer.getInstance();
	
	
	private Controller() {
		//JUST TO DEFY INSTANTIATION
	}
	/**
	 * Returns the unique instance of Controller to avoid multiple instances
	 * @return The single instance of Controller
	 */
	public static Controller getInstance() {
		return instance;
	}
	
	/**
	 * Returns an unmodifiable list of all the students
	 * @return a List&lt;Student&gt; object
	 */
	public List<Student> getStudents() {
		ArrayList<Student> temp = new ArrayList<Student>(dl.getStudents());		
		return Collections.unmodifiableList(temp);
	}
	
	/**
	 * Adds a student to the collection
	 * 
	 * @param id the id of the student
	 * @param firstName the first name of the student
	 * @param lastName the last name of the student
	 * @param email the email of the student
	 * @throws AlreadyExistsException
	 */
	public void addStudent(String id, String firstName, String lastName, String email) throws AlreadyExistsException {
		Student s = new Student(id,firstName,lastName,email);
		dl.addStudent(s);
	}
	/**
	 * Deletes a student from the student collection
	 * @param studentId the id of the student to delete
	 */
	public void deleteStudent(String studentId) {
		dl.deleteStudent(studentId);
	}
	/**
	 * Returns a map of String and ArrayList of Absence, key - value pairs
	 * @param studentID the ID of the student that has the absences
	 * @return a map of String and ArrayList of Absence, key - value pairs
	 * @throws NoDataFoundException
	 */
	public Map<String, ArrayList<Absence>> getStudentAbsences(String studentID) throws NoDataFoundException {
		Student s = dl.findStudentById(studentID);
		return Collections.unmodifiableMap(s.getAbsences());
	}
	/**
	 * Adds an absence to the specified student with the given unit id, classroom and date
	 * @param studentId
	 * @param unitId
	 * @param classroom
	 * @param date
	 * @throws NoDataFoundException
	 */
	public void addAbsenceToStudent(String studentId, String unitId, String classroom, String date) throws NoDataFoundException {
		dl.addAbsenceToStudent(studentId, new Absence(unitId, classroom, date));
	}
	/**
	 * Removes an absence from the specified student. In order to remove the correct absence the unit id, classroom and date of the absence
	 * is required
	 * @param studentId the id of the student to remove the absence from
	 * @param unitId the unit id of the absence
	 * @param classroom the classroom the absence was taken in
	 * @param date the date the absence was taken on
	 * @throws NoDataFoundException
	 */
	public void removeAbsenceFromStudent(String studentId, String unitId, String classroom, String date) throws NoDataFoundException {
		Student s =dl.findStudentById(studentId);
		s.removeAbsence(new Absence(unitId, classroom, date));
	}
	/**
	 * Returns an unmodifiable list of StudentGroups
	 * @return a List&lt;StudentGroup&gt; object
	 */
	public List<StudentGroup> getStudentGroups() {
		ArrayList<StudentGroup> temp = new ArrayList<StudentGroup>(dl.getStudentGroups());		
		return Collections.unmodifiableList(temp);
	}
	/**
	 * Adds a StudentGroup with the specified name to the collection
	 * @param name the name of the StudentGroup
	 * @throws AlreadyExistsException
	 */
	public void addStudentGroup(String name) throws AlreadyExistsException {
		StudentGroup sg = new StudentGroup(name);
		dl.addStudentGroup(sg);
	}
	
	/**
	 * Deletes a group from the StudentGroup collection
	 * @param groupId the id of the group to delete
	 * @throws NoDataFoundException 
	 */
	public void deleteStudentGroup(int groupId) throws NoDataFoundException {
		dl.deleteGroup(groupId);
	}
	
	/**
	 * Returns an unmodifiable list of the students in the specified group
	 * @param groupId the group id
	 * @return unmodifiable list of the students in the specified group
	 * @throws NoDataFoundException
	 */
	public List<Student> getStudentsInGroup(int groupId) throws NoDataFoundException {
		StudentGroup sg = dl.findGroupById(groupId);
		ArrayList<Student> temp = sg.getStudents();	
		return Collections.unmodifiableList(temp);
	}
	/**
	 * Adds the specified student to the specified group
	 * @param studentId the id of the student to be added
	 * @param groupId the id of the group to add the student to
	 * @throws NoDataFoundException
	 * @throws AlreadyExistsException
	 */
	public void addStudentToGroup(String studentId, int groupId) throws NoDataFoundException, AlreadyExistsException {
			Student s = dl.findStudentById(studentId);
			StudentGroup sg = dl.findGroupById(groupId);			
			sg.addStudent(s);
	}
	/**
	 * Removes the student specified from the given group
	 * @param studentId the id of the student to be removed
	 * @param groupId the id of the group to remove the student from
	 * @throws NoDataFoundException
	 */
	public void removeStudentFromGroup(String studentId, int groupId) throws NoDataFoundException {
		StudentGroup sg = dl.findGroupById(groupId);
		sg.removeStudent(studentId);
	}
	/**
	 * Returns an unmodifiable list of StudentGroups
	 * @return a List&lt;Unit&gt; object
	 */
	public List<Unit> getUnits() {
		ArrayList<Unit> temp = new ArrayList<Unit>(dl.getUnits());	
		return Collections.unmodifiableList(temp);
	}
	
	
	/**
	 * Adds a unit with the specified id, name and maximum absences to the collection
	 * @param id the id of the unit
	 * @param name the name of the unit
	 * @param maxAbsences the maximum absences allowed for the unit
	 * @throws AlreadyExistsException
	 */
	public void addUnit(String id, String name, int maxAbsences) throws AlreadyExistsException {
		dl.addUnit(new Unit(id, name, maxAbsences));
	}
	
	/**
	 * Deletes a unit from the student collection
	 * @param studentId the id of the student to delete
	 * @throws NoDataFoundException 
	 */
	public void deleteUnit(String unitId) throws NoDataFoundException {
		dl.deleteUnit(unitId);
	}
	
	/**
	 * Saves the StudentGroups in the collection to a file named studentGroups.dat
	 * @param filePath the directory path in which the file should be saved
	 * @throws IOException
	 */
	public void saveGroups(String filePath) throws IOException {
		dl.saveStudentGroups(new File(filePath+"studentGroups.dat"));
	}
	
	/**
	 * Saves the Students in the collection to a file named students.dat
	 * @param filePath the directory path in which the file should be saved
	 * @throws IOException
	 */
	public void saveStudents(String filePath) throws IOException {
		dl.saveStudents(new File(filePath+"students.dat"));
	}
	
	/**
	 * Saves the Units in the collection to a file named units.dat
	 * @param filePath the directory path in which the file should be saved
	 * @throws IOException
	 */
	public void saveUnit(String filePath) throws IOException {
		dl.saveUnits(new File(filePath+"units.dat"));
	}
	
	/**
	 * Saves the Students, Units and StudentGroups in the collection
	 * @param filePath the directory path in which the file should be saved
	 * @throws IOException
	 */
	public void saveAll(String filePath) throws IOException {
		dl.saveStudents(new File(filePath+"students.dat"));
		dl.saveStudentGroups(new File(filePath+"studentGroups.dat"));
		dl.saveUnits(new File(filePath+"units.dat"));
	}
	
	/**
	 * Loads the Students, Units and StudentGroups in the collection
	 * @param filePath the directory path in which the file should be saved
	 * @throws IOException
	 */
	public void loadAll() throws IOException, ClassNotFoundException {
		dl.loadStudents(new File("students.dat"));
		dl.loadStudentGroups(new File("studentGroups.dat"));
		dl.loadUnits(new File("units.dat"));
	}
	
	/** 
	 * Loads the StudentGroups to the collection
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void loadGroups() throws ClassNotFoundException, IOException {
		dl.loadStudentGroups(new File("studentGroups.dat"));
	}
	
	
	/** 
	 * Loads the Student to the collection
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */public void loadStudents() throws ClassNotFoundException, IOException {
		dl.loadStudents(new File("students.dat"));
	}
	
	/** 
	 * Loads the Units to the collection
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void loadUnits() throws ClassNotFoundException, IOException {
		dl.loadUnits(new File("units.dat"));
	}
}