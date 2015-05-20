/**
 * 
 */
package us.absencemanager;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Ioannis Boutsikas
 *
 */
public class StudentGroup2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3436520038042407800L;
	private String name;
	private ArrayList<Student> students;
	
	public StudentGroup2(String name) {
		setName(name);
		students = new ArrayList<Student>();
	}
	
	public void addStudent(Student s) {
		if(s != null) {
			students.add(s);
		}
	}
	
	public Student getStudent(String Id) {
		for (Student s: students) {
			if(s.getId() == Id) {
				return s;
			}
		}
		return null;
	}
	
	public ArrayList<Student> getStudentList() {
		return this.students;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((students == null) ? 0 : students.hashCode());
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
		StudentGroup2 other = (StudentGroup2) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}
	
}
