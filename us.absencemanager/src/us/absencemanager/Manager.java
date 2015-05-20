package us.absencemanager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Manager {
	private static Manager instance = new Manager();
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<StudentGroup2> studentGroups = new ArrayList<StudentGroup2>();
	
	
	private Manager() {
		//JUST TO DEFY INSTANTIATION
	}
	
	public static Manager getInstance() {
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public void loadStudentGroups(String filePath) {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("groups.dat"))){
			studentGroups = (ArrayList<StudentGroup2>)is.readObject();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
	}
	
	public void saveStudentGroups(String filePath) {
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("groups.dat"))){
			os.writeObject(studentGroups);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
	}
	
	@SuppressWarnings("unchecked")
	public void loadStudents(String filePath) {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("students.dat"))){
			students = ((ArrayList<Student>)is.readObject());
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
	}
	
	public void saveStudents(String filePath) {
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("students.dat"))){
			os.writeObject(students);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
	}
	public void addStudent(Student s) {
		if(s != null) {
			students.add(s);
		}
	}
	
	public void addStudentGroup(StudentGroup2 sg) {
		if(sg != null) {
			studentGroups.add(sg);
		}
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public ArrayList<StudentGroup2> getStudentGroups() {
		return studentGroups;
	}
}
