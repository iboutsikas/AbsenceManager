<<<<<<< HEAD
/**
 * 
 */
package us.absencemanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Student represents a Student with specific ID, name, email and a collection of Absences.
 * @author Ioannis Boutsikas
 *
 */
public class Student implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 295796725147927652L;
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private Map<String, ArrayList<Absence>> absences;
	
	/**
	 * Constructs and initializes a Student with given ID, first name, last name, and email.
	 * @param id The ID
	 * @param firstName The first name
	 * @param lastName The last name
	 * @param email The email
	 */
	public Student(String id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		absences = new TreeMap<String, ArrayList<Absence>>();
	}

	/**
	 * Adds a specific absence for the unit (specified by id) to the collection
	 * @param unitID The unit ID
	 * @param a The specific absence
	 */
	public void addAbsence(String unitID, Absence a) {
		try {
			ArrayList<Absence> temp = absences.get(unitID);
			if(temp !=null) {
				temp.add(a);
			} else {
				temp = new ArrayList<Absence>();
				temp.add(a);
			}
			absences.put(unitID, temp);
		}
		catch(ClassCastException | NullPointerException e) {
			System.out.println("Could not add absence");
		}
	}
	
	/**
	 * Displays all the absences in sysout, in tabular format.
	 */
	public void displayAbsences() {
		for(Map.Entry<String, ArrayList<Absence>> entry : absences.entrySet()) {
			String key = entry.getKey();
			ArrayList<Absence> value = entry.getValue();
	
			System.out.println("Unit "+ key +":");
			for(Absence a : value) {
				System.out.println("\t"+a);
			}
		}
	}
	/**
	 * @param id the Unit to get Absences for.
	 * @return ArrayList<Absence> the Absences for the unit specified
	 */
	public ArrayList<Absence> getAbsenceList(String id) {
		ArrayList<Absence> temp = this.absences.get(id);	
		return temp;
	}	
	/**
	 * @return the Id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
=======
/**
 * 
 */
package us.absencemanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Student represents a Student with specific ID, name, email and a collection of Absences.
 * @author Ioannis Boutsikas
 *
 */
public class Student implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 295796725147927652L;
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private Map<String, ArrayList<Absence>> absences;
	
	/**
	 * Constructs and initializes a Student with given ID, first name, last name, and email.
	 * @param id The ID
	 * @param firstName The first name
	 * @param lastName The last name
	 * @param email The email
	 */
	public Student(String id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		absences = new TreeMap<String, ArrayList<Absence>>();
	}

	/**
	 * Adds a specific absence for the unit (specified by id) to the collection
	 * @param unitID The unit ID
	 * @param a The specific absence
	 */
	public void addAbsence(String unitID, Absence a) {
		try {
			ArrayList<Absence> temp = absences.get(unitID);
			if(temp !=null) {
				temp.add(a);
			} else {
				temp = new ArrayList<Absence>();
				temp.add(a);
			}
			absences.put(unitID, temp);
		}
		catch(ClassCastException | NullPointerException e) {
			System.out.println("Could not add absence");
		}
	}
	
	/**
	 * Displays all the absences in sysout, in tabular format.
	 */
	public void displayAbsences() {
		for(Map.Entry<String, ArrayList<Absence>> entry : absences.entrySet()) {
			String key = entry.getKey();
			ArrayList<Absence> value = entry.getValue();
	
			System.out.println("Unit "+ key +":");
			for(Absence a : value) {
				System.out.println("\t"+a);
			}
		}
	}
	/**
	 * @param id the Unit to get Absences for.
	 * @return ArrayList<Absence> the Absences for the unit specified
	 */
	public ArrayList<Absence> getAbsenceList(String id) {
		ArrayList<Absence> temp = this.absences.get(id);	
		return temp;
	}	
	/**
	 * @return the Id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
>>>>>>> refs/heads/devB
