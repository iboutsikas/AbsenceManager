/**
 * 
 */
package us.absencemanager.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import us.absencemanager.exceptions.AlreadyExistsException;
import us.absencemanager.exceptions.NoDataFoundException;

/**
 * @author Kurga
 *
 */
public class DataLayer {
	private static DataLayer instance = new DataLayer();
	private LinkedHashSet<Student> students = new LinkedHashSet<Student>();
	private LinkedHashSet<StudentGroup> studentGroups = new LinkedHashSet<StudentGroup>();
	private LinkedHashSet<Unit> units = new LinkedHashSet<Unit>();;
	
	private DataLayer() {
		
	}
	
	public static DataLayer getInstance() {
		return instance;
	}
	public Student findStudentById(String id) throws NoDataFoundException {
		List<Student> s = students.stream()
								  .filter(p -> p.getId() == id)
								  .collect(Collectors.toList());
		if(s.size() == 0) {
			throw new NoDataFoundException("Could not find student with an id of :"+id);
		} else if (s.size() > 1) {
			throw new IllegalStateException("There is a double in a linked set. How did you manage that ?");
		} else {
			return s.get(0);
		}
	}

	/**
	 * Loads all of the saved Student objects into memory, from the specified file.
	 * @param filePath The filepath to the student file.
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void loadStudents(File file) throws ClassNotFoundException, IOException {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))){
			students = ((LinkedHashSet<Student>)is.readObject());
	    } catch (IOException e) {
	    	throw e;
	    } catch (ClassNotFoundException e) {
			throw e;
		}
	}

	/**
	 * Saves all of the available Student objects from memory, to the specified file.
	 * @param filePath The filepath to the student file.
	 * @throws IOException 
	 */
	public void saveStudents(File file) throws IOException {
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))){
			os.writeObject(students);
	    } catch (IOException e) {
	    	throw e;
	    }
	}

	/**
	 * Adds a student to the overall Student collection.
	 * @param s The Student to add.
	 * @throws AlreadyExistsException 
	 */
	public void addStudent(Student s) throws AlreadyExistsException {
		if (!students.contains(s)) {
			students.add(s);
		} else {
			throw new AlreadyExistsException("Student already exists!");
		}		
	}
	
	public void deleteStudent(String studentId) {
		List<Student> s = students.stream().filter(p -> p.getId().equals(studentId))
						 .collect(Collectors.toList());
		if(s.size() != 1) {
			throw new IllegalStateException("Could not find student with id " + studentId + " to delete.");
		} else {
			Student temp = s.get(0);
			students.remove(temp);
		}
	}
	
	/**
	 * Updates the existing student object with the data from the new
	 * NOTE: It does NOT include absences
	 * @param s the new student object
	 * @throws NoDataFoundException
	 */
	public void updateStudent(Student s) throws NoDataFoundException {
		List<Student> toUpdate = students.stream()
							.filter(p -> p.getId() == s.getId())
							.collect(Collectors.toList());
		if (toUpdate.size() == 1) {
			toUpdate.get(0).setFirstName(s.getFirstName());
			toUpdate.get(0).setLastName(s.getLastName());
			toUpdate.get(0).setEmail(s.getEmail());
		} else if(toUpdate.size() == 0) {
			throw new NoDataFoundException("Could not find user with id of: " + s.getId() + " to update");
		} else {
			throw new IllegalStateException("There were more than one students with id:" + s.getId() + ".\nSomething is seriously wrong;");
		}
	}

	/**
	 * 
	 * @return The complete list of Students
	 */
	
	public LinkedHashSet<Student> getStudents() {
		return students;
	}
	
	public void addAbsenceToStudent(String studentId, Absence a) throws NoDataFoundException {
		List<Student> s = students.stream()
							.filter(p -> p.getId() == studentId)
							.collect(Collectors.toList());
		if (s.size() != 1) {
			throw new NoDataFoundException("Could not add absence to student: " + studentId);
		} else {
			s.get(0).addAbsence(a.getUnitId(), a);
		}
	}

	public StudentGroup findGroupById(int id) throws NoDataFoundException {
		List<StudentGroup> sg = studentGroups.stream()
				  .filter(g -> g.getID() == id)
				  .collect(Collectors.toList());
		if(sg.size() == 0) {
		throw new NoDataFoundException("Could not find student group with an id of :"+id);
		} else if (sg.size() > 1) {
		throw new IllegalStateException("There is a double in a linked set. How did you manage that ?");
		} else {
		return sg.get(0);
		}
	}

	/**
	 * Loads all of the saved StudentGroup objects into memory, from the specified file.
	 * @param filePath The filepath to the group file.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("unchecked")
	public void loadStudentGroups(File file) throws IOException, ClassNotFoundException {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))){
			studentGroups = (LinkedHashSet<StudentGroup>)is.readObject();
	    } catch (IOException e) {
	    	throw e;
	    } catch (ClassNotFoundException e) {
			throw e;
		}
	}

	/**
	 * Saves all of the available StudentGroup objects from memory, to the specified file.
	 * @param filePath The filepath to the group file.
	 * @throws IOException 
	 */
	public void saveStudentGroups(File file) throws IOException {
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))){
			os.writeObject(studentGroups);
	    } catch (IOException e) {
	    	throw e;
	    }
	}

	/**
	 * Adds a StudentGroup to the overall StudentGroup collection.
	 * @param sg The StudentGroup to add.
	 * @throws AlreadyExistsException 
	 */
	public void addStudentGroup(StudentGroup sg) throws AlreadyExistsException {
		if (!studentGroups.contains(sg)) {
			studentGroups.add(sg);
		} else {
			throw new AlreadyExistsException("Student group already exists!");
		}
	}

	public void updateStudentGroup(StudentGroup sg) {
		
	}

	/**
	 * 
	 * @return The complete list of StudentGroups
	 */
	public LinkedHashSet<StudentGroup> getStudentGroups() {
		return studentGroups;
	}

	/**
	 * Loads all of the saved Unit objects into memory, from the specified file.
	 * @param filePath The filepath to the unit file.
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void loadUnits(File file) throws ClassNotFoundException, IOException {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))){
			units = ((LinkedHashSet<Unit>)is.readObject());
        } catch (IOException e) {
        	throw e;
        } catch (ClassNotFoundException e) {
			throw e;
		}
	}
	

	/**
	 * Saves all of the available Student objects from memory, to the specified file.
	 * @param filePath The filepath to the student file.
	 * @throws IOException 
	 */
	public void saveUnits(File file) throws IOException {
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))){
			os.writeObject(units);
        } catch (IOException e) {
        	throw e;
        }
	}	
	
	/**
	 * Adds a student to the overall unit collection.
	 * @param s the unit to add.
	 * @throws AlreadyExistsException 
	 */
	public void addUnit(Unit u) throws AlreadyExistsException {
		if (!units.contains(u)) {
			units.add(u);
		} else {
			throw new AlreadyExistsException("Unit already exists!");
		}
	}
	
	public void updateUnit(Unit u) {
		
	}
	
	/**
	 * 
	 * @return The complete list of Units
	 */
	public LinkedHashSet<Unit> getUnits() {
		return units;
	}
}
