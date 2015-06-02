/**
 * 
 */
package us.absencemanager.model;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import us.absencemanager.exceptions.AlreadyExistsException;
/**
 * A proxy class to be serialized in place of a StudentGroup object.
 * @author Ioannis Boutsikas
 */
class StudentGroupProxy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2137714849076341078L;
	transient DataLayer dl;
	private String name;
	private ArrayList<String> studentIDs;
	private int maxID;
	private int id;
	
	/**
	 * Creates a proxy object from a StudentGroup object.
	 * @param o The StudentGroup object to be converted.
	 */
	public StudentGroupProxy(StudentGroup o) {
		dl = DataLayer.getInstance();
		this.name = o.getName();
		this.id = o.getID();
		this.studentIDs = new ArrayList<String>();
		ArrayList<Student> temp = o.getStudents();		
		for(Student s: temp){
				studentIDs.add(s.getId());
		}
	}
	
	/**
	 * Creates a StudentGroup object from a serialized StudentGroupProxy object.
	 * @return A StudentGroup object
	 * @throws ObjectStreamException
	 * @throws AlreadyExistsException 
	 */
	private Object readResolve() throws ObjectStreamException, AlreadyExistsException {
		dl = DataLayer.getInstance();
		StudentGroup.initID(maxID);
		StudentGroup result = new StudentGroup(name);
		result.setID(this.id);
		LinkedHashSet<Student> temp = dl.getStudents();
		for (String s: studentIDs) {
			for(Student st: temp) {
				if(st.getId().equals(s)) {
					result.addStudent(st);
				}
			}
		}
		return result;
	}
	
}
/**
 * The StudentGroup represents a group of students. Has a name to be identified by and a collection of Students.
 * @author Ioannis Boutsikas
 *
 */
public class StudentGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3436520038042407800L;
	private static int maxID = 0;
	private String name;
	private ArrayList<Student> students;
	private int id;	
	protected static void initID(int id) {
		maxID = id;
	}
	/**
	 * Constructs and initializes a StudentGroup with given name 
	 * @param name The name of the group
	 */
	public StudentGroup(String name) {
		setName(name);
		students = new ArrayList<Student>();
		maxID++;
		this.id = maxID;
	}
	
	/**
	 * Serializes the object through a proxy, instead of directly.
	 * @return A StudentGroupProxy object.
	 * @throws java.io.ObjectStreamException
	 */
	private Object writeReplace() throws java.io.ObjectStreamException
    {
        return new StudentGroupProxy(this);
    }
	
	/**
	 * Adds a Student to the Student collection
	 * @param s The Student to add
	 * @throws AlreadyExistsException Student is already in the group
	 */
	public void addStudent(Student s) throws AlreadyExistsException {
		if (!students.contains(s)) {
			students.add(s);
		} else {
			throw new AlreadyExistsException("Student with id: " + s.getId() + " already exists in this group");
		}
		
	}
	/**
	 * Retrieves a Student by id, from the collection
	 * @param Id The id of the Student.
	 * @return The Student if found, null otherwise.
	 */
	public Student getStudent(String Id) {
		for (Student s: students) {
			if(s.getId() == Id) {
				return s;
			}
		}
		return null;
	}
	/**
	 * 
	 * @return The collection of Students
	 */
	public ArrayList<Student> getStudents() {
		return this.students;
	}
	
	/**
	 * @return the id
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * @param name the id to set
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentGroup other = (StudentGroup) obj;
		if (id != other.id)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
//		String str = "StudentGroup [name=" + name + ", id=" + id + "]\n";
//				for(Student s: students) {
//					str+="\t"+s.getId()+"\n";
//				}
//		return str;	
		return this.name;
	}
	
}
