package us.absencemanager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * The Manager class is a singleton. It handles interaction between the Model objects and the View.
 * @author Ioannis Boutsikas
 */
public class Manager {
	private static Manager instance = new Manager();
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<StudentGroup> studentGroups = new ArrayList<StudentGroup>();
	
	
	private Manager() {
		//JUST TO DEFY INSTANTIATION
	}
	/**
	 * 
	 * @return The single instance of Manager.
	 */
	public static Manager getInstance() {
		return instance;
	}
	
	/**
	 * Loads all of the saved StudentGroup objects into memory, from the specified file.
	 * @param filePath The filepath to the group file.
	 */
	@SuppressWarnings("unchecked")
	public void loadStudentGroups(String filePath) {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("groups.dat"))){
			studentGroups = (ArrayList<StudentGroup>)is.readObject();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
	}
	
	/**
	 * Saves all of the available StudentGroup objects from memory, to the specified file.
	 * @param filePath The filepath to the group file.
	 */
	public void saveStudentGroups(String filePath) {
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("groups.dat"))){
			os.writeObject(studentGroups);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
	}
	
	/**
	 * Loads all of the saved Student objects into memory, from the specified file.
	 * @param filePath The filepath to the student file.
	 */
	@SuppressWarnings("unchecked")
	public void loadStudents(String filePath) {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("students.dat"))){
			students = ((ArrayList<Student>)is.readObject());
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
	}
	
	/**
	 * Saves all of the available Student objects from memory, to the specified file.
	 * @param filePath The filepath to the student file.
	 */
	public void saveStudents(String filePath) {
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("students.dat"))){
			os.writeObject(students);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
	}
	
	/**
	 * Adds a student to the overall Student collection.
	 * @param s The Student to add.
	 */
	public void addStudent(Student s) {
		if(s != null) {
			students.add(s);
		}
	}
	
	/**
	 * Adds a StudentGroup to the overall StudentGroup collection.
	 * @param sg The StudentGroup to add.
	 */
	public void addStudentGroup(StudentGroup sg) {
		if(sg != null) {
			studentGroups.add(sg);
		}
	}
	
	/**
	 * 
	 * @return The complete list of Students
	 */
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	/**
	 * 
	 * @return The complete list of StudentGroups
	 */
	public ArrayList<StudentGroup> getStudentGroups() {
		return studentGroups;
	}
}
